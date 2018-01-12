import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class IncreaseSalaries {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("city");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        List<Employee> employeeList = em.createQuery("SELECT e FROM Employee e WHERE e.department.id IN(1,2,4,11)")
                .getResultList();

        for (Employee empl:employeeList) {
            em.detach(empl);
            empl.setSalary(empl.getSalary().add(empl.getSalary().multiply(BigDecimal.valueOf(0.12))));
            em.merge(empl);
        }

        em.getTransaction().commit();
        em.close();

    }
}
