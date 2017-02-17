package Repository;

 import IOMan.OutputWriter;
 import java.util.*;
 import java.util.stream.Collectors;

/**
 * Created by na4oy on 17.2.2017 г..
 */

public class RepositorySorters {
    public static void printSortedStudents(
            HashMap<String, ArrayList<Integer>> courseData,
            String comparisonType,
            int numberOfStudents) {

        Comparator<Map.Entry<String, ArrayList<Integer>>> comparator =
                Comparator.comparingDouble(x -> x.getValue()
                        .stream().mapToInt(Integer::valueOf).average().getAsDouble());

        List<String> sortedStudents = courseData.entrySet()
                .stream()
                .sorted(comparator)
                .limit(numberOfStudents)
                .map(s -> s.getKey())
                .collect(Collectors.toList());

        if ("descending".equals(comparisonType))
            Collections.reverse(sortedStudents);

        for (String student : sortedStudents)
            OutputWriter.printStudent(student, courseData.get(student));
    }
}