package StreamAPI;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by na4oy on 15.2.2017 г..
 */

public class UpperStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Arrays.stream(reader.readLine().split("\\s+"))
                .map(String::toUpperCase)
                .forEach(s -> System.out.print(s + " "));
    }
}
