package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SortOddNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(", ");

        List<Integer> numbers = new ArrayList<>();
        for (String s : input)
            numbers.add(Integer.valueOf(s));

        StringBuilder firstOutput = new StringBuilder();
        numbers.removeIf(n -> n % 2 != 0);
        for (Integer number : numbers)
            firstOutput.append(number).append(", ");
        firstOutput.delete(firstOutput.length() - 2, firstOutput.length());

        StringBuilder secondOutput = new StringBuilder()
                .append(firstOutput)
                .append(System.lineSeparator());
        numbers.sort(Integer::compareTo);
        for (Integer number : numbers)
            secondOutput.append(number).append(", ");
        secondOutput.delete(secondOutput.length() - 2, secondOutput.length());

        System.out.println(secondOutput);
    }
}