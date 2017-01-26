package JavaSyntax;

import java.util.Scanner;

public class ConvertFromDecimalToBase7 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter a decimal number :");
		int number = Integer.parseInt(scanner.nextLine());
		
		System.out.println("Converted to base-7 : ");
		System.out.print(Integer.toString(number,7));
	}

}
