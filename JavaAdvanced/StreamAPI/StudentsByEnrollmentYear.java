package StreamAPI;


import java.net.URISyntaxException;
        import java.util.Comparator;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;
        import java.util.stream.Collectors;

/**
 * Created by na4oy on 15.2.2017 г..
 */

public class StudentsByEnrollmentYear {
    public static void main(String[] args) throws URISyntaxException {
        List<Student> students = Main.getStudentsData();

        Map<Integer, List<Student>> studentsByYear = students.stream()
                .collect(Collectors.groupingBy(
                        s -> Integer.valueOf(
                                s.getFacultyNumber().substring(s.getFacultyNumber().length() - 2))));

        studentsByYear.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(year -> {
                    System.out.println("20" + year.getKey() + ":");
                    year.getValue().stream()
                            .sorted(Comparator.comparing(Student::getFirstName)
                                    .thenComparing(Student::getLastName))
                            .forEach(s -> System.out.printf("-- %s %s%n", s.getFirstName(), s.getLastName()));
                });
    }
}
