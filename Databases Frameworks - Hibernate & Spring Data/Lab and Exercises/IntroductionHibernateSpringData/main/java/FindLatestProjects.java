import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class FindLatestProjects {
    private static final String OUTPUT_STRING_FORMAT = "Project name: %s %n Project Description: %s  %n";

    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("city");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        List<Project> projectList = em.createQuery("SELECT p FROM Project p order by p.startDate desc ")
                .setMaxResults(10).getResultList();

        for (Project project :projectList) {
            System.out.printf(OUTPUT_STRING_FORMAT,
                    project.getName(),project.getDescription());

            System.out.println(" Project Start Date: " + project.getStartDate());
            System.out.println(" Project End Date: " + project.getEndDate());
        }

        em.getTransaction().commit();
        em.close();


    }
}
