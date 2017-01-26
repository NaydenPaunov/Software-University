package ProgramiBasics;

import java.util.Scanner;

public class lesson3_EvenOrOdd {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int Number = input.nextInt();
		
		if(Number % 2 == 0)
		{
			System.out.println("even");
		}
		else
		{
			System.out.println("Odd");
		}

	}

}
