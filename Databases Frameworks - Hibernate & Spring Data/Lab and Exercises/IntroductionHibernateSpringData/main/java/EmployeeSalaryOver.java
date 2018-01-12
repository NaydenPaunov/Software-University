import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeeSalaryOver {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("city");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();


        List<Employee> resultList = em.createQuery("SELECT e FROM Employee e where e.salary > 50000").getResultList();

        for (Employee emp: resultList){
            System.out.println(emp.getFirstName());
        }

        em.getTransaction().commit();
        em.close();
    }

}
