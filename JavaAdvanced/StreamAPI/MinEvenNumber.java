package StreamAPI;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalDouble;

/**
 * Created by na4oy on 15.2.2017 г..
 */

public class MinEvenNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        OptionalDouble result = Arrays.stream(reader.readLine().split("\\s+"))
                .filter(s -> ! "".equals(s))
                .mapToDouble(Double::valueOf)
                .filter(d -> d % 2 == 0)
                .min();

        System.out.println(result.isPresent() ? String.format("%.2f", result.getAsDouble()) : "No match");
    }
}
