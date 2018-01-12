import entities.Department;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeesMaximumSalaries {

    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("city");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        List<Department> departmentList = em.createQuery("SELECT d " +
                "FROM Department d " +
                "GROUP BY d.id").getResultList();

        for (Department department : departmentList) {
            List<Object> singleResult =  em.createQuery("Select max(e.salary) FROM Employee e WHERE e.department.id = ? group by e.department.id" +
                    " having max(e.salary) between 30000 and 70000")
                    .setParameter(0,department.getId())
                    .setMaxResults(1).getResultList();

                if(singleResult.size() != 0){
                    System.out.println(department.getName() + " - " + singleResult.get(0));
                }

        }
        em.getTransaction().commit();
        em.close();
    }
}
