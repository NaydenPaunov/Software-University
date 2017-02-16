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
import java.util.stream.Collectors;

/**
 * Created by na4oy on 15.2.2017 г..
 */

public class Inferno {
    private static List<Integer> GEMS;

    private static HashMap<String, Predicate> FILTERS = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        GEMS = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::valueOf)
                .boxed()
                .collect(Collectors.toList());

        Consumer<String> cmdProcessor = cmdLine -> {
            String[] tokens = cmdLine.split(";");

            switch (tokens[0]) {
                case "Exclude":
                    FILTERS.put(tokens[1].concat(tokens[2]), createFilter(tokens[1], Integer.valueOf(tokens[2])));
                    break;
                case "Reverse":
                    FILTERS.remove(tokens[1].concat(tokens[2]));
                    break;
            }
        };

        String input;
        while (! "Forge".equals(input = reader.readLine())) {
            cmdProcessor.accept(input);
        }

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < GEMS.size(); i++) {
            boolean valid = true;
            for (String filter : FILTERS.keySet()) {
                if (FILTERS.get(filter).test(i)) {
                    valid = false;
                    break;
                }
            }
            if (valid)
                output.append(GEMS.get(i)).append(' ');
        }

        System.out.println(output);
    }

    private static Predicate<Integer> createFilter(String condition, Integer value) {
        switch (condition) {
            case "Sum Left":
                return n -> {
                    if (n == 0)
                        return value.equals(GEMS.get(n));
                    return value.equals(GEMS.get(n) + GEMS.get(n - 1));
                };
            case "Sum right":
                return n -> {
                    if (n == GEMS.size() - 1)
                        return value.equals(GEMS.get(n));
                    return value.equals(GEMS.get(n) + GEMS.get(n + 1));
                };
            case "Sum Left Right":
                return n -> {
                    int sum = GEMS.get(n);

                    try {
                        sum += GEMS.get(n - 1);
                    } catch (Exception ignored) {}
                    try {
                        sum += GEMS.get(n + 1);
                    } catch (Exception ignored) {}

                    return value.equals(sum);
                };
        }
        return null;
    }
}