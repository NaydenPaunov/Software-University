package MethodsAndDebugging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by na4oy on 9.2.2017 г..
 */
public class CalculateTriangleArea {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double width = Double.parseDouble(reader.readLine());
        double height = Double.parseDouble(reader.readLine());
        double result = CalculatArea(width,height);

        if(result % 2 == 0 || result % 2 == 1){
            System.out.println(String.format("%.0f",result));
        }else {
            System.out.println(result);
        }
    }

    private static double CalculatArea(double width ,double height) {
        return (width*height)/2;
    }
}
