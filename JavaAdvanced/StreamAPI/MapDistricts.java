package StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by na4oy on 15.2.2017 г..
 */

public class MapDistricts {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, List<Integer>> cities = new HashMap<>();

        String[] tokens = reader.readLine().split("\\s+");
        int limit = Integer.valueOf(reader.readLine());

        for (String token : tokens) {
            String[] cityTokens = token.split(":");

            String name = cityTokens[0];
            int districtPopulation = Integer.valueOf(cityTokens[1]);

            cities.putIfAbsent(name, new ArrayList<>());
            cities.get(name).add(districtPopulation);
        }

        cities.entrySet().stream()
                .filter(c -> c.getValue().stream().mapToInt(Integer::valueOf).sum() >= limit)
                .sorted((e1, e2) -> Integer.compare(
                        e2.getValue().stream().mapToInt(Integer::valueOf).sum(),
                        e1.getValue().stream().mapToInt(Integer::valueOf).sum()))
                .forEach(e -> {
                    System.out.printf("%s: ", e.getKey());
                    e.getValue().stream()
                            .sorted((n1, n2) -> Integer.compare(n2, n1))
                            .limit(5)
                            .forEach(d -> System.out.print(d + " "));
                    System.out.println();
                });
    }
}
