package FunctionalProgramming;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;
/**
 * Created by na4oy on 15.2.2017 г..
 */

public class CountUpperCaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Predicate<String> startsWithUppercase = word -> Character.isUpperCase(word.charAt(0));

        String[] words = reader.readLine().split("\\s+");
        StringBuilder output = new StringBuilder();

        int upperCount = 0;
        for (String word : words) {
            if (startsWithUppercase.test(word)) {
                upperCount++;
                output.append(word).append(System.lineSeparator());
            }
        }

        System.out.printf("%s%n%s", upperCount, output);
    }
}