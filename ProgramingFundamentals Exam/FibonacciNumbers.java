package MethodsAndDebugging;


import java.util.Scanner;

public class FibonacciNumbers {

    public static void main(String a[]){
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt() + 1;
        int febCount = 100;
        int[] feb = new int[febCount];
        feb[0] = 0;
        feb[1] = 1;
        for(int i=2; i < febCount; i++){
            feb[i] = feb[i-1] + feb[i-2];
        }

        System.out.print(feb[input]);

    }
}
