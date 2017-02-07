package ManualStringProcessing;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

/**
 * Created by na4oy on 7.2.2017 г..
 */
public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Input
        String input = scanner.nextLine() ;
        String[] words = input.split(" ");
        //Print results from method
        System.out.println(CharacterMultiply(words[0],words[1]));
    }
     // Multiply character from first string with characters form second string
    public  static int CharacterMultiply (String firstStr,String secondStr){
        int sum = 0;
        int firstStringLenght =  firstStr.length();
        int secondStringLenght = secondStr.length();
        int smollest = Math.min(firstStringLenght,secondStringLenght);
        int bigest = Math.max(firstStringLenght,secondStringLenght);
        int diffrence = bigest - smollest;

        for (int i = 0; i < smollest; i++) {
            sum += (int)firstStr.charAt(i)*(int)secondStr.charAt(i);
        }

        if(diffrence > 0){
            if(firstStringLenght > secondStringLenght){
                for (int i = smollest; i <bigest ; i++) {
                    sum+= (int)firstStr.charAt(i);
                }
            }else{
                for (int i = smollest; i < bigest ; i++) {
                    sum+= (int)secondStr.charAt(i);
                }
            }
        }

        return sum;
    }
}
