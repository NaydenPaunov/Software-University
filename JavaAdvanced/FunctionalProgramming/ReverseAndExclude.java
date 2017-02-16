package FunctionalProgramming;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Created by na4oy on 15.2.2017 г..
 */

public class ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Consumer<List<Integer>> printer = list -> {
            Collections.reverse(list);
            StringBuilder output = new StringBuilder();
            list.forEach(n -> output.append(n).append(' '));
            System.out.println(output);
        };

        String[] input = reader.readLine().split("\\s+");
        Integer divisor = Integer.valueOf(reader.readLine());

        printer.accept(Arrays.stream(input)
                .mapToInt(Integer::valueOf)
                .filter(n -> n % divisor != 0).boxed().collect(Collectors.toList()));
    }
}
