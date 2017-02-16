package FunctionalProgramming;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Created by na4oy on 15.2.2017 г..
 */

public class CustomComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Comparator<Integer> myComparator = (n1, n2) -> {
            if ((n1 % 2 == 0) && (n2 % 2 != 0)) {
                return -1;
            }
            if ((n1 % 2 != 0) && (n2 % 2 == 0)) {
                return 1;
            }
            return n1.compareTo(n2);
        };

        Consumer<List<Integer>> printer = list -> {
            list.sort(myComparator);
            StringBuilder output = new StringBuilder();
            list.forEach(n -> output.append(n).append(' '));
            System.out.println(output);
        };

        printer.accept(Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::valueOf)
                .boxed()
                .collect(Collectors.toList()));
    }
}