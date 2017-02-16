package StreamAPI;



        import java.net.URISyntaxException;
        import java.util.Comparator;
        import java.util.List;
/**
 * Created by na4oy on 15.2.2017 г..
 */


public class StudentByGroup {
    public static void main(String[] args) throws URISyntaxException {
        List<Student> students = Main.getStudentsData();

        students.stream()
                .filter(s -> s.getGroup() == 2)
                .sorted(Comparator.comparing(Student::getFirstName))
                .forEach(s -> System.out.printf("%s %s%n", s.getFirstName(), s.getLastName()));
    }
}
