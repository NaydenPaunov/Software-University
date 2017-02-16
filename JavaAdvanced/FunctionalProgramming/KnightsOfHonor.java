package FunctionalProgramming;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

/**
 * Created by na4oy on 15.2.2017 г..
 */

public class KnightsOfHonor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Consumer<String[]> knightPrinter = arr -> {
            StringBuilder output = new StringBuilder();
            for (String name : arr)
                output.append("Sir ").append(name).append(System.lineSeparator());
            System.out.println(output);
        };

        knightPrinter.accept(reader.readLine().split("\\s+"));
    }
}