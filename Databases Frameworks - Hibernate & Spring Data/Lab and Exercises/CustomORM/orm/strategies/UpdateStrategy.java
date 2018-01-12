package orm.strategies;

import annotations.Column;
import annotations.Entity;
import annotations.Id;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class UpdateStrategy extends AbstactStrategy {

    @Override
    public void execute() throws SQLException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        List<Class> allEntities = getAllEntities();

        for (Class entity : allEntities){
            Field primary = this.getId(entity);
            primary.setAccessible(true);

            updateTable(entity, primary);
        }
    }

    private <E> boolean updateTable(Class entity, Field primary) throws IllegalAccessException, SQLException {
        String tableName = this.getTableName(entity);
        if(!this.checkIfTableExists(tableName)){
            this.doCreate(entity);
        }

        Field[] fields = entity.getDeclaredFields();

        for (int i = 1; i < fields.length; i++) {
            Field currentField = fields[i];
            currentField.setAccessible(true);

            Column columnAnnotation  = currentField.getAnnotation(Column.class);
            if(!this.checkIfFieldExists(tableName,columnAnnotation.name())){
                this.doAlter(tableName,currentField);
            }

        }
        return false;
    }

    public void doDelete(Class<?> table , String criteria) throws SQLException {
        String tableName = table.getAnnotation(Entity.class).name();
        if(!this.checkIfTableExists(tableName)){
            throw new IllegalArgumentException("Table does not exists!");
        }
        String query = "DELETE FROM " + this.dataSource + "." + tableName + " WHERE " + criteria ;
        this.connection.prepareStatement(query).execute();
    }

    private boolean checkIfTableExists(String tableName) throws SQLException {
        String query  = "SELECT table_name FROM INFORMATION_SCHEMA.TABLES " +
                "  WHERE table_schema = '" + this.dataSource +
                "' AND table_name = '" + tableName + "' LIMIT 1;";
        ResultSet rs = this.connection.prepareStatement(query).executeQuery();
        if(!rs.next()){
            return false;
        }
        return true;
    }

    private void doAlter(String tableName, Field field) throws SQLException {
        Column columnAnnotation = field.getAnnotation(Column.class);
        String query = "ALTER TABLE " + this.dataSource + "." + tableName + " ADD COLUMN "
                + columnAnnotation.name() + " " + this.getDbType(field);
        this.connection.prepareStatement(query).execute();
    }

    private <E> boolean checkIfFieldExists(String tableName, String columnName) throws SQLException {
        String query = "SELECT COLUMN_NAME FROM information_schema.`COLUMNS` WHERE TABLE_SCHEMA = '"+ this.dataSource
                + "' AND TABLE_NAME = '" + tableName +
                "' AND COLUMN_NAME = '" + columnName + "'";
        ResultSet rs = this.connection.prepareStatement(query).executeQuery();
        if(!rs.first()){
            return false;
        }
        return true;
    }

    private Field getId(Class entity){
        return Arrays.stream(entity.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Id.class))
                .findFirst()
                .orElseThrow(() -> new UnsupportedOperationException("Object does not have primary key"));
    }


}
