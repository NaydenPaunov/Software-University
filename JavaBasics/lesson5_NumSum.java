package ProgramiBasics;

import java.util.Scanner;

public class lesson5_NumSum {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int Sum = 0;
		for(int i = 0 ; i < n ; i++)
		{
			int a = input.nextInt();
			Sum += a;
		}
         
		System.out.println(Sum);
	}

}
