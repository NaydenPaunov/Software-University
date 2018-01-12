package orm;

import annotations.Column;
import annotations.Entity;
import annotations.Id;
import entities.User;
import orm.strategies.SchemaInitializationStrategy;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class EntityManager<E extends User> implements DbContext<E>{

    private Connection connection;
    private  String dataSource;
    private final SchemaInitializationStrategy strategy;

    public EntityManager(Connection connection, String dataSource, SchemaInitializationStrategy strategy) throws SQLException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        this.connection = connection;
        this.dataSource = dataSource;
        this.strategy = strategy;
         this.strategy.execute();
    }

    public <E> boolean persist(E entity) throws IllegalAccessException, SQLException {
        Field primary = this.getId(entity.getClass());
        primary.setAccessible(true);
        Object value = primary.get(entity);

        if(value == null || (int)value <= 0){
           return this.doInsert(entity,primary);
        }
        return this.doUpdate(entity,primary);

    }

    public void doDelete(Class<?> table , String criteria) throws SQLException {
        String tableName = table.getAnnotation(Entity.class).name();
        if(!this.checkIfTableExists(tableName)){
            throw new IllegalArgumentException("Table does not exists!");
        }
        String query = "DELETE FROM " + tableName + " WHERE " + criteria ;
        this.connection.prepareStatement(query).execute();
    }

    private <E> boolean doUpdate(E entity, Field primary) throws IllegalAccessException, SQLException {
        String tableName = this.getTableName(entity.getClass());
        String query = "UPDATE " + tableName + " SET ";
        String fieldNamesAndValues = "";
        String where = "";
        
        Field[] fields = entity.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field currentField = fields[i];
            currentField.setAccessible(true);

            if(currentField.getName().equals(primary.getName())){
                where += "WHERE `" + currentField.getAnnotation(Column.class).name() + "` =" + currentField.get(entity);
                continue;
            }else{
                if(currentField.get(entity) instanceof Date){
                    fieldNamesAndValues +="`" + currentField.getAnnotation(Column.class).name() + "` = '" +  new SimpleDateFormat("yyyy-MM-dd").format(currentField.get(entity)) + "'";
                }else{
                    fieldNamesAndValues += "`" + currentField.getAnnotation(Column.class).name() + "` = '" + currentField.get(entity) + "'";
                }
            }

            if(i < fields.length - 1){
                fieldNamesAndValues += ",";
            }
        }
        query += fieldNamesAndValues + where;
        return connection.prepareStatement(query).execute();
    }

    private <E> boolean doInsert(E entity, Field primary) throws IllegalAccessException, SQLException {
        String tableName = this.getTableName(entity.getClass());
        if(!this.checkIfTableExists(tableName)){
            this.doCreate(entity);
        }

        String query ="INSERT INTO " + tableName + "(";
        String fieldNames = "";
        String values = "";

        Field[] fields = entity.getClass().getDeclaredFields();

        for (int i = 1; i < fields.length; i++) {
            Field currentField = fields[i];
            currentField.setAccessible(true);

            fieldNames += "`" + currentField.getAnnotation(Column.class).name() + "`";

            Column columnAnnotation  = currentField.getAnnotation(Column.class);
            if(!this.checkIfFieldExists(tableName,columnAnnotation.name())){
                this.doAlter(tableName,currentField);
            }

            if(currentField.get(entity) instanceof Date){
                values +="'" +  new SimpleDateFormat("yyyy-MM-dd").format(currentField.get(entity)) + "'";
            }else {
                values += "'" + currentField.get(entity) + "'";
            }

            if(i < fields.length - 1){
                fieldNames += ",";
                values += ",";
            }
        }
        query += fieldNames + ") VALUES (" + values + ");";
        return connection.prepareStatement(query).execute();
    }

    private void doAlter(String tableName, Field field) throws SQLException {
        Column columnAnnotation = field.getAnnotation(Column.class);
        String query = "ALTER TABLE " + tableName + " ADD COLUMN "
                + columnAnnotation.name() + " " + this.getDbType(field);
        this.connection.prepareStatement(query).execute();
    }

    private <E> boolean checkIfFieldExists(String tableName, String columnName) throws SQLException {
        String query = "SELECT COLUMN_NAME FROM information_schema.`COLUMNS` WHERE TABLE_SCHEMA = 'orm_db' " +
                " AND TABLE_NAME = '" + tableName +
                "' AND COLUMN_NAME = '" + columnName + "'";
        ResultSet rs = this.connection.prepareStatement(query).executeQuery();
        if(!rs.first()){
            return false;
        }
        return true;
    }

    private <E> boolean doCreate(E entity) throws SQLException {
        String query = "CREATE TABLE " + this.getTableName(entity.getClass()) + " ( ";

        Field[] fields = entity.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field currentField = fields[i];
            currentField.setAccessible(true);

            query += " `" + currentField.getAnnotation(Column.class).name()  +
                    "` " + this.getDbType(currentField);

            if(currentField.isAnnotationPresent(Id.class)){
                query += " PRIMARY KEY AUTO_INCREMENT ";
            }
            if( i < fields.length - 1){
                query += ',';
            }
        }
        query += ") ";
        return this.connection.prepareStatement(query).execute();
    }

    private String getDbType(Field field) {
        String mySQLType = "";
        switch (field.getType().getSimpleName()){
            case "int":
            case "Integer":
                mySQLType = "INT";
                break;
            case "String":
                mySQLType = "VARCHAR(50)";
                break;
            case "Date" :
                mySQLType = "DATETIME";
                break;
        }
        return  mySQLType;
    }

    private boolean checkIfTableExists(String tableName) throws SQLException {
        String query  = "SELECT table_name FROM INFORMATION_SCHEMA.TABLES " +
                "  WHERE table_schema = 'orm_db' " +
                "  AND table_name = '" + tableName + "' LIMIT 1;";
        ResultSet rs = this.connection.prepareStatement(query).executeQuery();
        if(!rs.next()){
            return false;
        }
        return true;
    }

    public Iterable<E> find(Class<E> table) throws SQLException, IllegalAccessException, InstantiationException {
        String query = "SELECT * FROM " + this.getTableName(table)  + ";";
        Statement statement = connection.createStatement();
        ResultSet rs =statement.executeQuery(query);
        List<E> result = new ArrayList<>();

        while(rs.next()){
            E entity = table.newInstance();
            this.fillEntity(table,rs,entity);
            result.add(entity);
        }
        return result;
    }

    public Iterable<E> find(Class<E> table, String where) throws SQLException, IllegalAccessException, InstantiationException {
        String query = "SELECT * FROM " + this.getTableName(table)  + " WHERE " + where +  ";";
        Statement statement = connection.createStatement();
        ResultSet rs =statement.executeQuery(query);
        List<E> result = new ArrayList<>();

        while(rs.next()){
            E entity = table.newInstance();
            this.fillEntity(table,rs,entity);
            result.add(entity);
        }
        return result;
    }

    public E findFirst(Class<E> table) throws SQLException, IllegalAccessException, InstantiationException {
        String query = "SELECT * FROM " + this.getTableName(table) + " LIMIT 1;";
        Statement statement = connection.createStatement();
        E entity = table.newInstance();
        ResultSet rs =statement.executeQuery(query);
        rs.next();
        this.fillEntity(table,rs,entity);
        return entity;
    }

    public E findFirst(Class<E> table, String where) throws SQLException, IllegalAccessException, InstantiationException {
       String query = "SELECT * FROM " + this.getTableName(table)  + " WHERE " + where + " LIMIT 1;";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        E entity = table.newInstance();
        rs.next();
        this.fillEntity(table,rs,entity);
        return  entity;
    }

    private void fillEntity(Class<E> table, ResultSet rs, E entity) throws SQLException, IllegalAccessException {
        Field[] fields = table.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field currentField = fields[i];
            currentField.setAccessible(true);
            this.fillField(currentField,rs,currentField.getAnnotation(Column.class).name(),entity);
        }
    }

    private void fillField(Field currentField, ResultSet rs, String name, E entity) throws SQLException, IllegalAccessException {
        currentField.setAccessible(true);
        if(currentField.getType() == Integer.class || currentField.getType() == int.class){
            currentField.set(entity,rs.getInt(name));
        }else if(currentField.getType() == String.class){
            currentField.set(entity,rs.getString(name));
        }else if(currentField.getType() == Date.class){
            currentField.set(entity,rs.getDate(name));
        }
    }

    private Field getId(Class entity){
        return Arrays.stream(entity.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Id.class))
                .findFirst()
                .orElseThrow(() -> new UnsupportedOperationException("Object does not have primary key"));
    }

    private String getTableName(Class entity){
        String tableName = "";
        if(entity.isAnnotationPresent(Entity.class)){
            Entity annotations = (Entity) entity.getAnnotation(Entity.class);
            tableName = annotations.name();
        }
        if(tableName.equals("")){
            tableName = entity.getClass().getSimpleName();
        }
        return tableName;
    }

    public Connection getConnection() {
        return connection;
    }
}
