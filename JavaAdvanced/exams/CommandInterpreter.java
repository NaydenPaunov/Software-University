package exams;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by na4oy on 18.2.2017 г..
 */
public class CommandInterpreter {
    private static  ArrayList<String> result;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        result = new ArrayList<>(Arrays.asList(reader.readLine().trim().split("\\s+")));

        String[] command = reader.readLine().trim().split("\\s+");
        while (!command[0].equals("end")){
            switch (command[0]){
                case "reverse":
                    reverseCommand(Integer.parseInt(command[2]),Integer.parseInt(command[4]));
                    break;
                case "sort" :
                    sortCommand(Integer.parseInt(command[2]),Integer.parseInt(command[4]));
                    break;
                case "rollLeft" :
                    rollLeftCommand(Integer.parseInt(command[1]));
                    break;
                case "rollRight" :
                    rollRightCommand(Integer.parseInt(command[1]));
                    break;
                default:
                     break;
            }
            command = reader.readLine().trim().split("\\s+");
        }
        System.out.println(result);
    }

    private static void rollRightCommand(int count) {
            if (count < 0) {
                System.out.println("Invalid input parameters.");
                return;
            }
            count %= result.size();
            for (int i = 0; i < count; i++) {
                String remainder = result.get(result.size() - 1);
                result.remove(result.size() - 1);
                result.add(0, remainder);
            }

    }

    private static void rollLeftCommand(int count) {
            if (count < 0) {
                System.out.println("Invalid input parameters.");
                return;
            }
            count %= result.size();
            for (int i = 0; i < count; i++) {
                String remainder = result.get(0);
                result.remove(0);
                result.add(remainder);
            }


    }

    private static void sortCommand(int startIndex, int count) {
            if(count < 0 || startIndex < 0 || count >= result.size() || (count + startIndex) > result.size() ){
                System.out.println("Invalid input parameters.");
                return;
            }
            Integer endIndex = startIndex + count;
            ArrayList<String> remainder = new ArrayList<>(result.subList(startIndex,endIndex));
            Collections.sort(remainder);

            for (int i = startIndex; i < endIndex ; i++) {
                result.set(i,remainder.get(i - startIndex));
            }
    }

    private static void reverseCommand(int startIndex, int count) {
            if(count < 0 || startIndex < 0 || count >= result.size() || (count + startIndex) > result.size() ){
                System.out.println("Invalid input parameters.");
                return;
            }
            Integer endIndex = startIndex + count;
            ArrayList<String> remainder = new ArrayList<>(result.subList(startIndex, endIndex));
            Collections.reverse(remainder);

            for (int i = startIndex; i < endIndex; i++) {
                result.set(i, remainder.get(i - startIndex));
            }

    }
}
