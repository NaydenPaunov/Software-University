package FunctionalProgramming;

/**
 * Created by na4oy on 15.2.2017 г..
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class FilterByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Integer> people = new LinkedHashMap<>();

        int dataLinesCount = Integer.valueOf(reader.readLine());
        for (int i = 0; i < dataLinesCount; i++) {
            String[] tokens = reader.readLine().split(", ");
            people.put(tokens[0], Integer.valueOf(tokens[1]));
        }

        String condition = reader.readLine();
        Integer conditionAge = Integer.valueOf(reader.readLine());
        String[] displayFields = reader.readLine().split("\\s+");

        StringBuilder output = new StringBuilder();

        people.entrySet().stream().filter(n -> {
            switch (condition) {
                case "older":
                    if (n.getValue() >= conditionAge)
                        return true;
                    break;
                case "younger":
                    if (n.getValue() <= conditionAge)
                        return true;
                    break;
            }
            return false;
        }).forEach(n -> {
            if (displayFields.length == 2) {
                switch (displayFields[0]) {
                    case "name":
                        output.append(String.format("%s - %s", n.getKey(), n.getValue()))
                                .append(System.lineSeparator());
                        break;
                    case "age":
                        output.append(String.format("%s - %s", n.getValue(), n.getKey()))
                                .append(System.lineSeparator());
                        break;
                }
            } else if (displayFields.length == 1) {
                switch (displayFields[0]) {
                    case "name":
                        output.append(String.format("%s", n.getKey()))
                                .append(System.lineSeparator());
                        break;
                    case "age":
                        output.append(String.format("%s", n.getValue()))
                                .append(System.lineSeparator());
                        break;
                }
            }
        });

        System.out.println(output);
    }
}