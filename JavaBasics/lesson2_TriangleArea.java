package ProgramiBasics;

import java.util.Scanner;

public class lesson2_TriangleArea {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("a = ");
		double a = input.nextDouble();
		System.out.print("h = ");
		double h = input.nextDouble();
		
		double area = (a*h)/2;
		
		System.out.printf("Area = %f",area);
		
		

	}

}
