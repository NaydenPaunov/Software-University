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

public class FindSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Function<List<Integer>, Integer> getMinNumberIndex = list -> {
            Integer minElement = Collections.min(list);
            Integer minElementInd = 0;
            for (int i = 0; i < list.size(); i++) {
                if (minElement.equals(list.get(i)))
                    minElementInd = i;
            }
            return minElementInd;
        };

        System.out.println(getMinNumberIndex.apply(Arrays
                .stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::valueOf)
                .boxed()
                .collect(Collectors.toList())));
    }
}
