package StreamAPI;


import java.net.URISyntaxException;
import java.util.List;
/**
 * Created by na4oy on 15.2.2017 г..
 */
public class FilterStudentsByEmailDomain {
    public static void main(String[] args) throws URISyntaxException {
        List<Student> students = Main.getStudentsData();

        students.stream()
                .filter(s -> s.getEmail().endsWith("@gmail.com"))
                .forEach(s -> System.out.printf("%s %s %s%n",
                        s.getFirstName(), s.getLastName(), s.getEmail()));
    }
}
