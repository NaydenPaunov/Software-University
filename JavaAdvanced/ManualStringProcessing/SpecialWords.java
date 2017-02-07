package ManualStringProcessing;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by na4oy on 6.2.2017 г..
 */
public class SpecialWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] specialWords = scanner.nextLine().split(" ");
        String[] text = scanner.nextLine().split(" ");

        HashMap<String,Integer> result = new HashMap<>();
        for (String specialWord : specialWords) {
            result.put(specialWord,0);
        }

        for (String specialWord : specialWords) {
            for (String s : text) {
                if(specialWord.compareToIgnoreCase(s) == 0){
                    result.put(specialWord,result.get(specialWord) + 1);
                }
            }
        }

        for (String key : result.keySet()) {
            System.out.println(String.format("%s - %d",key,result.get(key)));
        }


    }
}
