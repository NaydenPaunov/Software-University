package StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * Created by na4oy on 15.2.2017 г..
 */


public class BoundedNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] bounds = Stream.of(reader.readLine().split("\\s+"))
                .mapToInt(Integer::valueOf)
                .sorted()
                .toArray();

        Stream.of(reader.readLine().split("\\s+"))
                .map(Integer::valueOf)
                .filter(x -> bounds[0] <= x && x <= bounds[1])
                .forEach(x -> System.out.print(x + " "));
    }
}
