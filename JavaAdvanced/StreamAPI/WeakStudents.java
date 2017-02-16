package StreamAPI;


import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.List;

/**
 * Created by na4oy on 15.2.2017 г..
 */

public class WeakStudents {
    public static void main(String[] args) throws URISyntaxException {
        List<Student> students = Main.getStudentsData();

        students.stream()
                .filter(s -> s.getGrades().stream().filter(g -> g <= 3).count() >= 2)
                .sorted(Comparator.comparingDouble(s2 -> s2.getGrades()
                        .stream().mapToInt(Integer::valueOf).average().getAsDouble()))
                .forEach(s -> {
                    System.out.printf("%s %s ", s.getFirstName(), s.getLastName());
                    s.getGrades().stream()
                            .sorted()
                            .forEach(g -> System.out.print(g + " "));
                    System.out.println();
                });
    }
}
