package FunctionalProgramming;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by na4oy on 15.2.2017 г..
 */

public class BiggestSmallestInteger {
    private interface TriFunction<T, T1, T2, T3> {
        T3 apply(T t, T1 y, T2 u);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> resultList = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::valueOf)
                .boxed()
                .collect(Collectors.toList());

        String action = reader.readLine();
        String minMax = action.substring(0, 3);
        String oddEven = action.substring(3);

        Function<List<Integer>, Integer> maxFunc = Collections::max;
        Function<List<Integer>, Integer> minFunc = Collections::min;

        TriFunction<Function, List<Integer>, String, String> customFunc = (function, numbers, request) -> {
            int remainder = request.equals("Odd") ? 1 : 0;

            numbers = numbers.stream().filter(e -> e % 2 == remainder).collect(Collectors.toList());

            return numbers.size() > 0 ? function.apply(numbers).toString() : null;
        };

        String output = null;
        switch (minMax) {
            case "max":
                output = customFunc.apply(maxFunc, resultList, oddEven);
                break;
            case "min":
                output = customFunc.apply(minFunc, resultList, oddEven);
                break;
        }
        System.out.print(output != null ? output : "");
    }
}
