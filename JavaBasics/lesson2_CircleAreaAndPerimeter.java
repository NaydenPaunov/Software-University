package ProgramiBasics;

import java.util.Scanner;

public class lesson2_CircleAreaAndPerimeter {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("r = ");
		double r = input.nextDouble();
		
		double pi = Math.PI;
		double area = pi*r*r;
		double perimeter = 2*pi*r;
		
		System.out.printf("Area = %f%n Perimeter = %f",area,perimeter);
		
		

	}

}
