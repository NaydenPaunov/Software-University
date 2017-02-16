package StreamAPI;

import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.List;

/**
 * Created by na4oy on 15.2.2017 г..
 */

public class ExcellentStudents {
    public static void main(String[] args) throws URISyntaxException {
        List<Student> students = Main.getStudentsData();

        students.stream()
                .filter(s -> s.getGrades().contains(6))
                .forEach(s -> {
                    System.out.printf("%s %s ", s.getFirstName(), s.getLastName());
                    s.getGrades().stream()
                            .sorted(Comparator.reverseOrder())
                            .forEach(g -> System.out.print(g + " "));
                    System.out.println();
                });
    }
}
