package StreamAPI;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.function.Predicate;
/**
 * Created by na4oy on 15.2.2017 г..
 */
public class FindAndumIntegers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Predicate<String> isNumber = s -> {
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if ((i == 0) && (chars[i] == '-' || chars[i] == '+'))
                    continue;

                if (!Character.isDigit(chars[i]))
                    return false;
            }
            return true;
        };

        OptionalInt sum = Arrays.stream(reader.readLine().split("\\s+"))
                .filter(s -> ! "".equals(s))
                .map(String::trim)
                .filter(isNumber)
                .map(s -> s.replace("+", ""))
                .mapToInt(Integer::valueOf)
                .reduce((x1, x2) -> x1 + x2);

        System.out.println(sum.isPresent() ? sum.getAsInt() : "No match");
    }
}
