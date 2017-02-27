package MethodsAndDebugging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by na4oy on 9.2.2017 г..
 */
public class MathPower {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double number = Double.parseDouble(reader.readLine());
        int power = Integer.parseInt(reader.readLine());
        double result = Pow(number,power);

        if(result % 2 == 0 || result % 2 == 1){
            System.out.println(String.format("%.0f",result));
        }else {
            System.out.println(result);
        }
    }

    private static double Pow(double number, int power) {
        double result = 1;
        if(number == 0 && power == 0){
            return 0;
        }
        for (int i = 0; i < power ; i++) {
            result =result* number;
        }
        return  result;
    }
}
