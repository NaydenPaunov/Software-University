package FunctionalProgramming;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Created by na4oy on 15.2.2017 г..
 */

public class PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Consumer<List<String>> printer = list -> {
            StringBuilder output = new StringBuilder();
            list.forEach(name -> output.append(name).append(System.lineSeparator()));
            System.out.println(output);
        };

        Integer maxLength = Integer.valueOf(reader.readLine());
        printer.accept(Arrays.stream(reader.readLine().split("\\s+"))
                .filter(n -> n.length() <= maxLength)
                .collect(Collectors.toList()));
    }
}
