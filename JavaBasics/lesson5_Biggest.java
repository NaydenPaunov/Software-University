package ProgramiBasics;

import java.util.Scanner;

public class lesson5_Biggest {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		int biggest = Integer.MIN_VALUE;
		for(int i = 0 ; i < n ; i++)
		{  
			int a = input.nextInt();
			if(a > biggest){
				biggest = a;
			}
		}
		System.out.println(biggest);

	}

}
