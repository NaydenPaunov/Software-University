package ManualStringProcessing;

import java.util.Scanner;

/**
 * Created by na4oy on 7.2.2017 г..
 */
public class TextFilter {
    public static void main(String[] args) {
        //Input
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(", ");
        StringBuilder sb = new StringBuilder(scanner.nextLine());

        //Searching word in stringBuilder and replace it with stars
        for (int i = 0; i < words.length; i++) {
            while(sb.indexOf(words[i]) != -1){
                int startIndex = sb.indexOf(words[i]);
                int endIndex = sb.indexOf(words[i]) + words[i].length();
                sb.replace(startIndex,endIndex,replaceWithStars(words[i]));
            }
        }
        //Print
        System.out.println(sb.toString());

    }
    //Method to replace every Character with star
    public  static String replaceWithStars (String word){
        int wordLenght = word.length();
        String stars = "";
        for (int i = 0; i < wordLenght ; i++) {
            stars += "*";
        }

        return stars;
    }
}