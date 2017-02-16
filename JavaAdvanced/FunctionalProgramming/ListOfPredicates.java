package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by na4oy on 15.2.2017 г..
 */

public class ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int limit = Integer.valueOf(reader.readLine());
        List<Integer> divisors = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::valueOf).boxed().collect(Collectors.toList());

        Predicate<Integer> isValid = n -> {
            for (Integer divisor : divisors) {
                if (n % divisor != 0)
                    return false;
            }
            return true;
        };

        StringBuilder output = new StringBuilder();
        for (int i = 1; i <= limit; i++) {
            if (isValid.test(i))
                output.append(i).append(' ');
        }

        System.out.println(output);
    }
}
