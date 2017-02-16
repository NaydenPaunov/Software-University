package StreamAPI;


import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.List;
/**
 * Created by na4oy on 15.2.2017 г..
 */

public class SoftStudents {
    public static void main(String[] args) throws URISyntaxException {
        List<Student> students = Main.getStudentsData();

        students.stream()
                .sorted(Comparator.comparing(Student::getLastName)
                        .thenComparing((s1, s2) -> s2.getFirstName()
                                .compareTo(s1.getFirstName())))
                .forEach(s -> System.out.printf("%s %s%n", s.getFirstName(), s.getLastName()));
    }
}
