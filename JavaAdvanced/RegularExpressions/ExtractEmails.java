package RegularExpressions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by na4oy on 8.2.2017 г..
 */
public class ExtractEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String line = "";
        while (!"end".equals(line = reader.readLine())){
            sb.append(line);
        }

        Pattern pattern = Pattern.compile("(?<email>(?<=\\s|^)[A-Za-z]+[-._]*[a-zA-Z]+@(?:[A-Za-z]+[-]*[A-Za-z]+(?:\\.[A-Za-z]+)+)(?=[!?. ,]|$))");
        Matcher matcher = pattern.matcher(sb.toString());

        while (matcher.find()){
            System.out.println(matcher.group("email"));
        }
    }
}
