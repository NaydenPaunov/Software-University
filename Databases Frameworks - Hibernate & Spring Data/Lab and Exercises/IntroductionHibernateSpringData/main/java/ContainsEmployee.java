import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ContainsEmployee {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputName = reader.readLine().split("\\s+");
        String firstName = inputName[0];
        String lastName= inputName[1];

        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("city");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        List<Employee> result = em.createQuery("SELECT e FROM Employee e WHERE e.firstName LIKE ? and e.lastName LIKE ?")
                .setParameter(0,firstName)
                .setParameter(1,lastName).getResultList();

        if(result.size() == 1){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
        em.getTransaction().commit();
        em.close();
    }
}
