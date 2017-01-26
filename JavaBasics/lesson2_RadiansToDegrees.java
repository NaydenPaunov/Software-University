package ProgramiBasics;

import java.util.Scanner;

public class lesson2_RadiansToDegrees {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Radians = ");
		double radians = input.nextDouble();
		double degrees = (radians*180)/Math.PI;
		
		System.out.printf("Degrees = %d",Math.round(degrees));
		

	}

}
