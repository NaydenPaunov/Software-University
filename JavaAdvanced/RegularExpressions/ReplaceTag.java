package RegularExpressions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by na4oy on 8.2.2017 г..
 */
public class ReplaceTag {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = "" ;
        StringBuilder input = new StringBuilder();
        while (!"END".equals(line = reader.readLine())){
            input.append(line).append("\r\n");
        }

        Pattern pattern = Pattern.compile("<a(\\s+href=[^>]+)>([^<]+)<\\/a>");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            int getStartMach = matcher.start();
            int getEndMach = matcher.end();
            String replacement = tagReplacement(matcher);
            input = input.replace(getStartMach,getEndMach,replacement);
            matcher = pattern.matcher(input);
        }
        System.out.println(input);

    }
private  static String tagReplacement(Matcher matcher){
        return "[URL" + matcher.group(1) + "]" + matcher.group(2) + "[/URL]";
}
}

