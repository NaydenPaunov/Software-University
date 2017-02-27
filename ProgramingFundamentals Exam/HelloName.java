package MethodsAndDebugging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by na4oy on 9.2.2017 г..
 */
public class HelloName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String  name = reader.readLine();
        System.out.println(ReturnHelloName(name));
    }

    private static String ReturnHelloName(String name) {
        String hello = "Hello, "+ name +"!";
        return hello;
    }

}
