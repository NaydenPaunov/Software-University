package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class RemoveTowns {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String townName  = reader.readLine();

        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("city");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        Town town = (Town) em.createQuery("SELECT t FROM Town t WHERE t.name = ? ").setParameter(0,townName)
                .setMaxResults(1).getSingleResult();
        List<Address> addressList =
                em.createQuery("SELECT a FROM Address a WHERE a.town.id = ? ")
                        .setParameter(0,town.getId()).getResultList();

        int deletedAddressCount = 0;
        for (Address address:addressList){
            List<Employee> employeeList = em.createQuery("SELECT e FROM Employee e WHERE e.address.id = ?")
                    .setParameter(0,address.getId()).getResultList();
            for (Employee employee: employeeList) {
                em.detach(employee);
                employee.setAddress(null);
                em.merge(employee);
            }

            em.remove(address);
            deletedAddressCount++;
        }
        System.out.printf("%d address in %s deleted",deletedAddressCount,town.getName());
        em.remove(town);

        em.getTransaction().commit();
        em.close();
    }
}
