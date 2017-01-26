package ProgramiBasics;

import java.util.Scanner;

public class lesson2_USDToBGN {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("USD = ");
		
		double usd = input.nextDouble();
		double usdToBgn = 1.79549 ;
		double bgn = usd*usdToBgn;
		
		System.out.printf("%f",bgn);
		

	}

}
