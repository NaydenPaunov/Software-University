package exams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by na4oy on 17.2.2017 г..
 */
public class RageQuit {
    private static HashSet<Character> uniqueSymbols  = new HashSet<>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        Pattern pattern = Pattern.compile("(\\D+)(\\d+)");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            String text = matcher.group(1).toUpperCase();
            Integer repeatNum = Integer.parseInt(matcher.group(2));

            if(repeatNum != 0) {
                for (int j = 0; j < text.length(); j++) {
                    uniqueSymbols.add(text.charAt(j));
                }
            }
            for (int i = 0; i < repeatNum; i++) {
                sb.append(text);
            }
        }
        System.out.println("Unique symbols used: " + uniqueSymbols.size());
        System.out.println(sb.toString());
    }
}
