package FunctionalProgramming;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Created by na4oy on 15.2.2017 г..
 */

public class FindEvensOrOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Consumer<List<Integer>> printer = list -> {
            StringBuilder output = new StringBuilder();
            list.forEach(n -> output.append(n).append(' '));
            System.out.println(output);
        };

        BiPredicate<Integer, String> filter = (num, condition) -> {
            switch (condition) {
                case "even":
                    return num % 2 == 0;
                case "odd":
                    return num % 2 != 0;
            }
            return false;
        };

        String[] input = reader.readLine().split("\\s+");
        Integer start = Integer.valueOf(input[0]);
        Integer end = Integer.valueOf(input[1]);
        String condition = reader.readLine();

        List<Integer> numbers = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            numbers.add(i);
        }

        printer.accept(numbers.stream().filter(n -> filter.test(n, condition)).collect(Collectors.toList()));
    }
}