package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.BiPredicate;

/**
 * Created by na4oy on 15.2.2017 г..
 */
public class TriiFunction {
    private interface TriFunction<T, T1, T2, T3> {
        T3 apply(T t, T1 y, T2 u);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int targetNumber = Integer.parseInt(reader.readLine());
        String[] inputNames = reader.readLine().split("\\s+");

        TriFunction<Integer, BiPredicate<String, Integer>, String[], String> triFunction =
                (number, biFunction, collection) -> {
                    for (String name : collection)
                        if (biFunction.test(name, number))
                            return name;
                    return null;
                };

        BiPredicate<String, Integer> biFunction = (string, number) -> {
            int sum = 0;
            for (char letter : string.toCharArray())
                sum += letter;
            return sum >= number;
        };

        String result = triFunction.apply(targetNumber, biFunction, inputNames);
        System.out.print( result != null ? result : "");
    }
}
