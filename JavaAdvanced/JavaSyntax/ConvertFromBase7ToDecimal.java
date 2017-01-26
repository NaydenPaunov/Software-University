package JavaSyntax;

import java.util.Scanner;

public class ConvertFromBase7ToDecimal {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	 
        System.out.println("Enter the a base-7 number you want to convert to decimal: ");
       
        String numberToConvert = scanner.next();
        
        try {
            Integer decimalRepresentation = Integer.valueOf(numberToConvert, 7);
            System.out.println(decimalRepresentation);
        }catch (NumberFormatException e) {
            System.out.println("You have entered an invalid number");
        }


    }
}