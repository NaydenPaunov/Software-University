package ProgramiBasics;

import java.util.Scanner;

public class lesson3_GreaterNumber {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int A = input.nextInt();
		int B = input.nextInt();
		
		if(A > B)
		{
			System.out.println(A);
		}
		else
		{
			System.out.println(B);
		}

	}

}
