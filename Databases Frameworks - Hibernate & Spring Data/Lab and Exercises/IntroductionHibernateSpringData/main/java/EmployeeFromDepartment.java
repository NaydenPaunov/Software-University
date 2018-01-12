import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeeFromDepartment {
    private static final String OUTPUT = "%s %s from %s - $%.2f %n";
    private static final String DEPARTMENT = "Research and Development";

    public static void main(String[] args) {

        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("city");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        List<Employee> employeeList = em.createQuery("SELECT e FROM Employee e WHERE e.department.name = ?" +
                " ORDER BY e.salary asc , e.id asc ").setParameter(0,DEPARTMENT).getResultList();

        for (Employee employee:employeeList){
            System.out.printf(OUTPUT,
                    employee.getFirstName(),employee.getLastName(),DEPARTMENT,employee.getSalary());
        }

        em.getTransaction().commit();
        em.close();
    }

}
