package ProgramiBasics;

import java.util.Scanner;

public class lesson2_InchesToCentimeters {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Inches = ");
		double inches = input.nextDouble();
		double inchesToCentimeters = 2.54;
		double Centimeters = inches * inchesToCentimeters;
		
		System.out.println("Centimeters = "+ Centimeters);
		

	}

}
