package ProgramiBasics;

import java.util.Scanner;

public class lesson2_CurrencyConverter {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		double usdToBgn = 1.79549;
		double euroToBgn = 1.95583;
		double gbpToBgn = 2.53405;
		
		System.out.print("N = ");
		double N = input.nextDouble();
		String to = input.nextLine();
		String from = input.nextLine();
		
	
		
		
		if( from == "USD")
		{
			N = N*usdToBgn;
		}
		else if(from == "EUR")
		{
			N = N*euroToBgn;
		}
		else if (from == "GBP")
		{
			N = N*gbpToBgn;
		}
		else if(from == "BGN")
		{
			
		}
		else
		{
		 System.out.println("Wrong value");
		}
		
		
		
		if( to == "USD")
		{
			N = N/usdToBgn;
		}
		else if(to == "EUR")
		{
			N = N/euroToBgn;
		}
		else if (to == "GBP")
		{
			N = N/gbpToBgn;
		}
		else if(to == "BGN")
		{
			
		}
		else
		{
		 System.out.println("Wrong value");
		}
		
		System.out.printf("%.2f",N );
		

	}

}
