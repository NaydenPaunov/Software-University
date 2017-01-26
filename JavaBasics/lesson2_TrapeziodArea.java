package ProgramiBasics;

import java.util.Scanner;

public class lesson2_TrapeziodArea {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		
		System.out.print("b1 = ");
		double b1 = input.nextDouble();
		System.out.print("b2 = ");
		double b2 = input.nextDouble();
		System.out.print("h = ");
		double h = input.nextDouble();
		
		double area = (b1 +b2)*(h/2);
		
		System.out.printf("Area = %f ",area);
	}

}
