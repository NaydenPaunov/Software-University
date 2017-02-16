package FunctionalProgramming;

/**
 * Created by na4oy on 15.2.2017 г..
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> parser = Integer::valueOf;

        String[] input = reader.readLine().split(", ");
        int sum = 0;
        for (String s : input)
            sum += parser.apply(s);

        System.out.printf("Count = %s%nSum = %s", input.length, sum);
    }
}