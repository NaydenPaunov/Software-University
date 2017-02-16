package StreamAPI;

/**
 * Created by na4oy on 15.2.2017 г..
 */
import java.net.URISyntaxException;
import java.util.List;

public class FilterStudentsByPhone {
    public static void main(String[] args) throws URISyntaxException {
        List<Student> students = Main.getStudentsData();

        students.stream()
                .filter(s -> s.getPhone().startsWith("02") || s.getPhone().startsWith("+3592"))
                .forEach(s -> System.out.printf("%s %s %s%n",
                        s.getFirstName(), s.getLastName(), s.getPhone()));
    }
}
