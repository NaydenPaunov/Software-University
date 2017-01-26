package ProgramiBasics;

import java.util.Scanner;

public class lesson1_SquareOfStars {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("N = ");
		int n = input.nextInt();
		
		for(int i = 0 ; i < n ; i++)
		{
			System.out.print("*");
		}
		System.out.println("");
		
		
		
		for(int g = 0 ; g < n- 1 ;g++)
		{
		for(int i = 0 ; i < 2 ; i++)
		{
			System.out.print("*");
			for(int j = 0 ; j < n-2 ; j++)
			{
				System.out.print(" ");
			}
			
		}
		System.out.println();
		}
		
		for(int i = 0 ; i < n ; i++)
		{
			System.out.print("*");
		}
		
		
	}

}
