package ProgramiBasics;

import java.util.Scanner;

public class lesson1_Area {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("A= ");
		int a = input.nextInt();
		System.out.print("b= ");
		int b = input.nextInt();
		
		int area = a * b;
		
		System.out.println("area = " + area);
		
		
	}

}
