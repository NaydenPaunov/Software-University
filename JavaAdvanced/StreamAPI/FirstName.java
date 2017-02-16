package StreamAPI;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by na4oy on 15.2.2017 г..
 */

public class FirstName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = Arrays.asList(reader.readLine().split("\\s+"));

        HashSet<Character> startLetters = Arrays
                .stream(reader.readLine().split("\\s+"))
                .map(s -> Character.toLowerCase(s.charAt(0)))
                .collect(Collectors.toCollection(HashSet::new));

        Optional<String> foundName = names.stream()
                .filter(n -> startLetters.contains(Character.toLowerCase(n.charAt(0))))
                .sorted()
                .findFirst();

        System.out.println(foundName.isPresent() ? foundName.get() : "No match");
    }
}
