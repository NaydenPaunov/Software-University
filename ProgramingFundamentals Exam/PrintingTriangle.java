package MethodsAndDebugging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by na4oy on 9.2.2017 г..
 */
public class PrintingTriangle {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(reader.readLine());

        PrintingTrianglee(input);
    }

    private static void PrintingTrianglee(int num) {
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        for (int i = num; i >= 1 ; i--) {
            for (int j = 1; j < i ; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
