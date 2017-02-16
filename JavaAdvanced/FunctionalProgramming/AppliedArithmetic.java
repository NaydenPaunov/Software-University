package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * Created by na4oy on 15.2.2017 г..
 */

public class AppliedArithmetic {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays
                .stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::valueOf)
                .boxed()
                .collect(Collectors.toList());

        Consumer<String> calculator = action -> {
            switch (action) {
                case "add":
                    for (int i = 0; i < numbers.size(); i++)
                        numbers.set(i, numbers.get(i) + 1);
                    break;
                case "multiply":
                    for (int i = 0; i < numbers.size(); i++)
                        numbers.set(i, numbers.get(i) * 2);
                    break;
                case "subtract":
                    for (int i = 0; i < numbers.size(); i++)
                        numbers.set(i, numbers.get(i) - 1);
                    break;
                case "print":
                    StringBuilder output = new StringBuilder();
                    numbers.forEach(n -> output.append(n).append(' '));
                    System.out.println(output);
                    break;
            }
        };

        String action;
        while (! "end".equals(action = reader.readLine()))
            calculator.accept(action);
    }
}
