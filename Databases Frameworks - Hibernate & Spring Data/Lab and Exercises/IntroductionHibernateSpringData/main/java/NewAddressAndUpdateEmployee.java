import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NewAddressAndUpdateEmployee {
    private static final String ADDRESS_NAME = "Vitoshka 15";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String lastName = reader.readLine();

        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("city");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        Address newAddress = new Address();
        newAddress.setText(ADDRESS_NAME);
        em.persist(newAddress);

        Employee found = (Employee) em.createQuery("SELECT e FROM Employee e WHERE e.lastName = ? ")
                .setParameter(0,lastName).setMaxResults(1).getSingleResult();

        found.setAddress(newAddress);

        em.getTransaction().commit();
        em.close();
    }
}
