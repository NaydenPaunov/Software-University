package ProgramiBasics;

import java.util.Scanner;

public class lesson3_100NumberToText {

	public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
         
         int n = input.nextInt();
         
         
         String[] primes = new String[] {"zero","one","two","three","four","five","six","seven","eight","nine"};
         
         String[] numbers = new String[] {"eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};

         String[] num = new String[] {"ten","twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninety","one hundred"};
         
         
         if(n < 0 || n > 100)
         {
        	 System.out.println("Invalid number");
         }
         else if( n >= 0 && n <= 9)
         {
        	 System.out.println(primes[n]);
         }
         else if( n > 10 && n < 20 )
         {
        	 System.out.println(numbers[n-11]);
         }
         else if( n > 20 && n < 30)
         {
        	 System.out.print(num[1] + " " +primes[n-20]);
         }
         else if( n > 30 && n < 40)
         {
        	 System.out.print(num[2] + " " +primes[n-30]);
         }
         else if( n > 40 && n < 50)
         {
        	 System.out.print(num[3] + " " +primes[n-40]);
         }
         else if( n > 50 && n < 60)
         {
        	 System.out.print(num[4] + " " +primes[n-50]);
         }
         else if( n > 60 && n < 70)
         {
        	 System.out.print(num[5] + " " +primes[n-60]);
         }
         else if( n > 70 && n < 80)
         {
        	 System.out.print(num[6] + " " +primes[n-70]);
         }
         else if( n > 80 && n < 90)
         {
        	 System.out.print(num[7] + " " +primes[n-80]);
         }
         else if( n > 90 && n < 100)
         {
        	 System.out.print(num[8] + " " +primes[n-90]);
         }
         else if( n % 10 == 0)
         {
        	 n = n / 10 - 1 ;
        	 System.out.println(num[n]);
         }
         
         
         
	}

}
