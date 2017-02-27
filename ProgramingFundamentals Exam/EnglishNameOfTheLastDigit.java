package MethodsAndDebugging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by na4oy on 9.2.2017 г..
 */
public class EnglishNameOfTheLastDigit {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long input = Long.parseLong(reader.readLine());
        String englishName =GetEnglishNameOfLastDigit(input);
        System.out.println(englishName);
    }

    private static String GetEnglishNameOfLastDigit(long input) {
        long lastDigit = input % 10;

        if(lastDigit == 0 ){
            return "zero";
        }else if (lastDigit == 1){
            return "one";
        }else if (lastDigit == 2){
            return "two";
        }else if (lastDigit == 3){
            return "three";
        }else if(lastDigit == 4 ){
            return "four";
        }else if(lastDigit == 5){
            return "five";
        }else if(lastDigit == 6 ){
            return "six";
        }else if (lastDigit == 7){
            return "seven";
        }else if (lastDigit == 8){
            return "eight";
        }else if(lastDigit == 9){
            return "nine";
        }else
        {
            return "wrong";
        }

    }


}
