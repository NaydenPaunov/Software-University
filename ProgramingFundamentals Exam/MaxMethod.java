package MethodsAndDebugging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by na4oy on 9.2.2017 г..
 */
public class MaxMethod {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int firstNumber = Integer.parseInt(reader.readLine());
        int secondNumber = Integer.parseInt(reader.readLine());
        int thirdNumber = Integer.parseInt(reader.readLine());
        int maxNumber = GetMax(firstNumber,secondNumber,thirdNumber);
        System.out.println(maxNumber);
    }

    private static int GetMax(int firstNumber, int secondNumber, int thirdNumber) {
        if(firstNumber > secondNumber && firstNumber > thirdNumber){
            return  firstNumber;
        }else if(secondNumber > firstNumber && secondNumber > thirdNumber){
            return  secondNumber;
        }else {
            return thirdNumber;
        }
    }

}
