package ProgramiBasics;

import java.util.Scanner;

public class lesson3_ExcellentOrNot {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		double grade = input.nextDouble();
		
		if(grade >= 5.50)
		{
			System.out.println("Excellent");
		}
		else
		{
			System.out.println("Not excellent");
		}

	}

}
