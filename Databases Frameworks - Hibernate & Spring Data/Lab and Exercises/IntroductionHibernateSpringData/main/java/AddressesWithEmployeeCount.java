import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AddressesWithEmployeeCount {
    private static final String OUTPUT_FORMAT = "%s, %s  - %d employees %n";

    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("city");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        List<Address> addressList = em.createQuery("SELECT a FROM Address a ORDER BY a.employees.size desc,a.town.id asc")
                .setMaxResults(10).getResultList();

        for (Address address:addressList) {
            System.out.printf(OUTPUT_FORMAT,address.getText(),address.getTown().getName(),address.getEmployees().size());
        }

        em.getTransaction().commit();
        em.close();

    }
}
