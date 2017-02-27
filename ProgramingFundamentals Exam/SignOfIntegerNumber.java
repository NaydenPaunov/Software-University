package MethodsAndDebugging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by na4oy on 9.2.2017 г..
 */
public class SignOfIntegerNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(reader.readLine());
        PrintNumberSign(input);
    }

    private static void PrintNumberSign(int num) {
        if(num > 0){
            System.out.println(String.format("The number %d is positive.",num));
        }else if(num < 0){
            System.out.println(String.format("The number %d is negative.",num));
        }else {
            System.out.println(String.format("The number %d is zero.",num));
        }
    }




}
