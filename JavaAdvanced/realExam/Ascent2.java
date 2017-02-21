

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Created by na4oy on 19.2.2017 г..
 */
    public class Ascent2 {
        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            Pattern pattern = Pattern.compile("([,_])([A-Za-z]+)([0-9])");
            String line = reader.readLine();

            while (!"Ascend".equals(line))
            {
                Matcher match = pattern.matcher(line);

                while (match.find())
                {
                    char symbol = match.group(1).charAt(0);
                    String message = match.group(2);
                    int matcher = Integer.parseInt(match.group(3));
                    String entireMessage = String.valueOf(symbol) + message + matcher;
                    StringBuilder newMessage = new StringBuilder();

                    if (symbol == ',')
                    {
                        for (char mes : message.toCharArray()) {
                            newMessage.append((char) ((int)mes + matcher));
                        }
                    }
                    else
                    {
                        for (char mes : message.toCharArray()) {
                            newMessage.append((char) ((int)mes - matcher));
                        }
                    }
                    line = line.replace(entireMessage, newMessage.toString());
                    match = pattern.matcher(line);
                }

                System.out.println(line);
                line = reader.readLine();
            }
        }
    }


