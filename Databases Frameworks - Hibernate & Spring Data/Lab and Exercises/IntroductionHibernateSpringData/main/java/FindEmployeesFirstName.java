import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class FindEmployeesFirstName {

    private static final String OUTPUT_STRING_FORMAT = "%s %s - %s - ($%.2f)%n";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine()+"%";

        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("city");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        List<Employee> employeeList = em.createQuery("SELECT e FROM Employee e WHERE e.firstName LIKE ? ")
                .setParameter(0,input).getResultList();

        for (Employee employee: employeeList){
            System.out.printf(OUTPUT_STRING_FORMAT,
                    employee.getFirstName(),employee.getLastName(),employee.getJobTitle(),employee.getSalary());
        }

        em.getTransaction().commit();
        em.close();

    }
}
