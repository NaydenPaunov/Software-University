import orm.Connector;
import orm.EntityManager;
import orm.EntityManagerBuilder;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import static orm.scanner.EntityScanner.getAllEntities;

public class Main {
    public static void main(String[] args) throws IOException, SQLException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//         getAllEntities(System.getProperty("user.dir"));

        Connector c = new Connector(new EntityManagerBuilder());

        EntityManager e = new EntityManagerBuilder()
                .configureConnectionString()
                .setDriver("jdbc")
                .setAdapter("mysql")
                .setHost("localhost")
                .setPort("3306")
                .setUser("root")
                .setPass("05040504nn")
                .createConnection()
                .configureCreationType()
                .setUpdateStrategy()
                .setDataSource("asd")
                .build();

//        EntityManager entityManager = new EntityManager<>(con);


    }
}
