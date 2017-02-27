package MethodsAndDebugging;

import java.io.PrintWriter;

/**
 * Created by na4oy on 9.2.2017 г..
 */
public class BlankReceipt {
    public static void main(String[] args) {
        PrintHeader();
        PrintBody();
        PrintFooter();
    }

    public static void PrintFooter() {
        System.out.println("------------------------------");
        System.out.println("© SoftUni");
    }

    public static void PrintBody() {
        System.out.println("Charged to____________________");
        System.out.println("Received by___________________");
    }

    public static void PrintHeader(){
        System.out.println("CASH RECEIPT");
        System.out.println("------------------------------");
    }

}
