package RegularExpressions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by na4oy on 8.2.2017 г..
 */
public class ValidTime {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2}) [AP]M$");
        String line = reader.readLine();

        while(!line.equals("END")){
            Matcher matcher = pattern.matcher(line);

            if(matcher.find()){
              int hours = Integer.parseInt(matcher.group(1));
              int minutes = Integer.parseInt(matcher.group(2));
              int seconds = Integer.parseInt(matcher.group(3));

                 if(isValidTime(hours,minutes,seconds)){
                     System.out.println("valid");
                 }else{
                     System.out.println("invalid");
                 }

            }else{
                System.out.println("invalid");
            }
            line = reader.readLine();

        }


    }


    public  static boolean isValidTime(int hour , int minutes , int seconds){
        if(!(hour >= 1 && hour <= 12)) {
            return false;
        }
        if(!(minutes >= 0 && minutes <= 59)){
            return false;
        }
        if(!(seconds >= 0 && seconds <= 59)){
             return false;
        }
         return true;
        }
}