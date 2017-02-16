package StreamAPI;


        import java.net.URISyntaxException;
        import java.nio.file.Files;
        import java.nio.file.Path;
        import java.nio.file.Paths;
        import java.util.ArrayList;
        import java.util.List;

/**
 * Created by na4oy on 15.2.2017 г..
 */

public class Main {
    public static List<Student> getStudentsData() throws URISyntaxException {
        Path studentsDataPath = Paths.get(Main.class.getResource("StudentData.txt").toURI());
        List<String> data = new ArrayList<>();

        try {
            data = Files.readAllLines(studentsDataPath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Student> students = new ArrayList<>();
        for (int i = 1; i < data.size(); i++) {
            String[] tokens = data.get(i).split("\\s+");
            String facNum = tokens[0];
            String firstName = tokens[1];
            String lastName = tokens[2];
            String email = tokens[3];
            Integer age = Integer.valueOf(tokens[4]);
            Integer group = Integer.valueOf(tokens[5]);
            String phone = tokens[10];

            Student student = new Student(
                    facNum, firstName, lastName, email, age, group, phone);

            for (int gradeIndex = 6; gradeIndex <= 9; gradeIndex++) {
                Integer grade = Integer.valueOf(tokens[gradeIndex]);
                student.getGrades().add(grade);
            }

            students.add(student);
        }

        return students;
    }
}