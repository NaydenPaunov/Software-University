package FunctionalProgramming;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.BiConsumer;

/**
 * Created by na4oy on 15.2.2017 г..
 */

public class PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> people = Arrays.asList(reader.readLine().split("\\s+"));

        LinkedHashMap<String, Integer> peopleCount = new LinkedHashMap<>();
        people.forEach(name -> peopleCount.put(name, 1));

        BiConsumer<String, List<String>> cmdInterpreter = (cmdLine, list) -> {
            String[] cmdTokens = cmdLine.split("\\s+");

            switch (cmdTokens[0]) {
                case "Remove":
                    switch (cmdTokens[1]) {
                        case "StartsWith":
                            for (String name : list) {
                                if (name.startsWith(cmdTokens[2]))
                                    peopleCount.remove(name);
                            }
                            break;
                        case "EndsWith":
                            for (String name : list) {
                                if (name.endsWith(cmdTokens[2]))
                                    peopleCount.remove(name);
                            }
                            break;
                        case "Length":
                            for (String name : list) {
                                if (name.length() == Integer.valueOf(cmdTokens[2]))
                                    peopleCount.remove(name);
                            }
                            break;
                    }
                    break;
                case "Double":
                    switch (cmdTokens[1]) {
                        case "StartsWith":
                            for (String name : list) {
                                if (name.startsWith(cmdTokens[2]))
                                    if (peopleCount.containsKey(name))
                                        peopleCount.put(name, peopleCount.get(name) * 2);
                            }
                            break;
                        case "EndsWith":
                            for (String name : list) {
                                if (name.endsWith(cmdTokens[2]))
                                    if (peopleCount.containsKey(name))
                                        peopleCount.put(name, peopleCount.get(name) * 2);
                            }
                            break;
                        case "Length":
                            for (String name : list) {
                                if (name.length() == Integer.valueOf(cmdTokens[2]))
                                    if (peopleCount.containsKey(name))
                                        peopleCount.put(name, peopleCount.get(name) * 2);
                            }
                            break;
                    }
                    break;
            }
        };

        String input;
        while (! "Party!".equals(input = reader.readLine())) {
            cmdInterpreter.accept(input, people);
        }

        if (peopleCount.isEmpty()) {
            System.out.println("Nobody is going to the party!");
            return;
        }

        StringBuilder output = new StringBuilder();
        for (String person : peopleCount.keySet()) {
            for (int i = 0; i < peopleCount.get(person); i++) {
                output.append(person).append(", ");
            }
        }

        output.delete(output.length() - 2, output.length()).append(" are going to the party!");

        System.out.println(output);
    }
}