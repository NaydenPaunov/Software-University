package ProgramiBasics;

import java.util.Scanner;

public class lesson3_pool {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int v = input.nextInt();
		int p1 = input.nextInt();
		int p2 = input.nextInt();
		double h = input.nextDouble();
		
		
		
		double LitreP1P2 = p1*h + p2*h;
	   	
	    double fullPool = LitreP1P2*100/v;
	    double pire1 = (p1*h)*100/LitreP1P2;
	    double pire2 = (p2*h)*100/LitreP1P2;
	    
	    if(v > LitreP1P2)
	    {
	    System.out.printf("The pool is %d full.Pire 1 : %d  Pire 2 : %d ", (int)fullPool,(int)pire1,(int)pire2);
	    }
	    else
	    {   double Overflow = LitreP1P2 - v;
	    	System.out.printf("For %.1f hours the pool overflow with %d litres",h,(int)Overflow);
	    }
    
	}

}
