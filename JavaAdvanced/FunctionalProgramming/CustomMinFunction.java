package FunctionalProgramming;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by na4oy on 15.2.2017 г..
 */

public class CustomMinFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Function<List<Integer>, Integer> getMinNumber = list -> {
            Integer min = Integer.MAX_VALUE;
            for (Integer num : list) {
                if (num < min)
                    min = num;
            }
            return min;
        };

        System.out.println(
                getMinNumber
                        .apply(Arrays.stream(reader.readLine().split("\\s+"))
                                .mapToInt(Integer::valueOf)
                                .boxed()
                                .collect(Collectors.toCollection(ArrayList::new))));
    }
}