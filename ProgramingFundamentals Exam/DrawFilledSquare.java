package MethodsAndDebugging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by na4oy on 9.2.2017 г..
 */
public class DrawFilledSquare {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(reader.readLine());

        PrintHeaderRow(input);
        for (int i = 0; i < input - 2; i++) {
            PrintMiddleRow(input);
        }
        PrintHeaderRow(input);

    }

    public static void PrintMiddleRow(int input) {
        System.out.print('-');
        for (int j = 1; j < input ; j++) {
                System.out.print("\\/");
        }
        System.out.println('-');

    }

    public static void PrintHeaderRow(int num) {
        for (int i = 0; i < num*2 ; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
