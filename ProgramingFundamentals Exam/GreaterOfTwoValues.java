package MethodsAndDebugging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by na4oy on 9.2.2017 г..
 */
public class GreaterOfTwoValues {
    public static void main(String[] args) throws IOException {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       String input = reader.readLine();

        if(input.equals("int")){
            int firstNumber = Integer.parseInt(reader.readLine());
            int secondNumber = Integer.parseInt(reader.readLine());

            if(firstNumber > secondNumber){
                System.out.println(firstNumber);
            }else{
                System.out.println(secondNumber);
            }

        }else if(input.equals("string")){
            String firstString = reader.readLine();
            String secondString = reader.readLine();

            if(firstString.compareTo(secondString) >= 0){
                System.out.println(firstString);
            }else{
                System.out.println(secondString);
            }

        }else if(input.equals("char")){
            String firstString = reader.readLine();
            String secondString = reader.readLine();

            if(firstString.compareTo(secondString) >= 0){
                System.out.println(firstString);
            }else{
                System.out.println(secondString);
            }

        }

    }
}
