package FunctionalProgramming;



    import java.io.BufferedReader;
            import java.io.IOException;
            import java.io.InputStreamReader;
            import java.util.ArrayList;
            import java.util.Arrays;
            import java.util.HashMap;
            import java.util.List;
            import java.util.function.Consumer;
            import java.util.function.Predicate;

/**
 * Created by na4oy on 15.2.2017 г..
 */

public class PartyReservationFilterModule {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = Arrays.asList(reader.readLine().split("\\s+"));

        HashMap<String, Predicate> filters = new HashMap<>();
        Consumer<String> cmdInterpreter = cmdLine -> {
            String[] tokens = cmdLine.split(";");

            switch (tokens[0]) {
                case "Add filter":
                    filters.put(tokens[1].concat(";").concat(tokens[2]), createFilter(tokens[1], tokens[2]));
                    break;
                case "Remove filter":
                    filters.remove(tokens[1].concat(";").concat(tokens[2]));
                    break;
            }
        };

        String input;
        while (! "Print".equals(input = reader.readLine())) {
            cmdInterpreter.accept(input);
        }

        StringBuilder output = new StringBuilder();
        for (String name : names) {
            boolean valid = true;
            for (String filterName : filters.keySet()) {
                if (!filters.get(filterName).test(name)) {
                    valid = false;
                    break;
                }
            }

            if (valid)
                output.append(name).append(' ');
        }
        System.out.println(output);
    }

    private static Predicate<String> createFilter(String condition, String value) {
        switch (condition) {
            case "Starts with":
                return name -> ! name.startsWith(value);
            case "Ends with":
                return name -> ! name.endsWith(value);
            case "Length":
                return name -> name.length() != Integer.valueOf(value);
            case "Contains":
                return name -> ! name.contains(value);
        }
        return null;
    }
}