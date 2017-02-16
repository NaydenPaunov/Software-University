package FunctionalProgramming;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

/**
 * Created by na4oy on 15.2.2017 г..
 */

public class ConsumerPrint {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Consumer<String[]> printer = arr -> {
            for (String name : arr)
                System.out.println(name);
        };

        printer.accept(reader.readLine().split("\\s+"));
    }
}