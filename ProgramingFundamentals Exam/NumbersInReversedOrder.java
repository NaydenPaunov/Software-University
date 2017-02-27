package MethodsAndDebugging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by na4oy on 9.2.2017 г..
 */
public class NumbersInReversedOrder {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        StringBuilder sb = new StringBuilder(""+input);
        sb.reverse();
        System.out.println(sb);
    }
}
