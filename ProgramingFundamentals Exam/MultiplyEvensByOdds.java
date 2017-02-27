package MethodsAndDebugging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by na4oy on 9.2.2017 г..
 */
public class MultiplyEvensByOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String secondInput = input;
        String firstChar = ""+input.charAt(0);
        if(firstChar.equals("-")){

            char[] chars = input.toCharArray();
            secondInput = "";
            for (int i = 1; i <chars.length ; i++) {
                secondInput += chars[i];
            }
        }

        int sumOfOdd = GetSumOfOdd(secondInput);
        int sumOfEven = GetSumOfEven(secondInput);
        System.out.println(sumOfEven*sumOfOdd);

    }

    private static int GetSumOfEven(String input) {
        int sum = 0;
        for (int i = 0; i < input.length() ; i++) {
            char chars = input.charAt(i);
            int number = chars - '0';
            if(number % 2 == 0){
                sum += number;
            }
        }
        return sum;
    }

    private static int GetSumOfOdd(String input) {
     int sum = 0;
        for (int i = 0; i < input.length() ; i++) {
            int number = input.charAt(i) - '0';
            if(number % 2 != 0){
                sum += number;
            }
        }
        return sum;
    }


}
