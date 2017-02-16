package RegularExpressions;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

/**
 * Created by na4oy on 8.2.2017 г..
 */
public class SentenceExtractor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String keyWors = reader.readLine().trim();
        String text = reader.readLine().trim();

        Pattern pattern =  Pattern.compile("[a-zA-Z\\s’_-]*(?<=\\s|^)"+Pattern.quote(keyWors)+
                "(?=\\s|[!.?,])[A-Za-z \\s’_-]*(?=[!?.])(?:[!.?]?)");
        Matcher matcher = pattern.matcher(text);

        while(matcher.find()) {
            System.out.println(matcher.group().trim());
        }






    }
}
