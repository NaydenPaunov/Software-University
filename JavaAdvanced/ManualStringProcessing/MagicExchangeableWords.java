package ManualStringProcessing;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by na4oy on 7.2.2017 г..
 */
public class MagicExchangeableWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[]  input = scanner.nextLine().split(" ");
        String longerString = input[0];
        String shorterString = input[1];

        HashMap<Character,Character> charMap = new HashMap<>();

        if(longerString.length() < shorterString.length()){
            String remainder = longerString;
            longerString = shorterString;
            shorterString = remainder;
        }

        boolean isMagic = isMagic(charMap,longerString, shorterString);
        System.out.println(isMagic);

    }

    private  static boolean isMagic(HashMap<Character,Character> charsMap , String longestStr,String shortestStr){
        boolean isMagic = true;

        for (int i = 0; i < shortestStr.toCharArray().length; i++) {
            if (!charsMap.containsKey(longestStr.charAt(i))) {
                charsMap.put(longestStr.charAt(i), shortestStr.charAt(i));
            } else if (charsMap.get(longestStr.charAt(i)) != shortestStr.charAt(i)) {
                isMagic = false;
                break;
            }
        }

        if (isMagic) {
            for (int i = shortestStr.length(); i < longestStr.length(); i++) {
                if(!charsMap.containsKey(longestStr.charAt(i))){
                    isMagic = false;
                    break;
                }
            }
        }


        return  isMagic;
    }
}
