package ProgramiBasics;

import java.util.Scanner;

public class lesson2_CelsiusToFahrenheit {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Celsius = ");
		double celsius = input.nextDouble();
		
		double fahrenheit = celsius*1.8000 + 32;
		
		System.out.printf("Fahrenheit = %.2f", fahrenheit);


	}

}
