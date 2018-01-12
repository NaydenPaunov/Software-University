package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GetEmployeeWithProject {

    public static final String OUTPUT_STRING = "%s %s - %s %n";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int employee_id = Integer.parseInt(reader.readLine());

        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("city");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        Employee employee = (Employee) em.createQuery("SELECT e FROM Employee e WHERE e.id = ? ORDER BY e.firstName ASC")
                .setParameter(0,employee_id)
                .setMaxResults(1).getSingleResult();

        Set<Project> projects = employee.getProjects().stream().sorted(Comparator.comparing(Project::getName))
                .collect(Collectors.toSet());

        System.out.printf(OUTPUT_STRING,employee.getFirstName(),employee.getLastName(),employee.getJobTitle());
        for (Project project: projects) {
            System.out.println(project.getName());
        }

        em.getTransaction().commit();
        em.close();

    }
}
