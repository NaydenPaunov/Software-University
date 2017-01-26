package javaBasics;

import java.util.Scanner;
/*
Задача 3. Велосъстезание
Предстои велосъстезание за благотворителност в което учасниците са разпределени в младша(“juniors”) и старша(“seniors”) група.
Парите се набавят от таксата за участие на велосипедистите. Според възрастовата група и вида на трасето на което ще се провежда
състезанието, таксата е различна.

Група	     trail	cross-country	downhill	road

juniors      5.50	     8	        12.25	    	 20

seniors       7            9.50   	13.75		21.50

Ако в „cross-country“ състезанието се съберат 50 или повече участника(общо младши и старши), таксата  намалява с 25%.
Организаторите отделят 5% процента от събраната сума за разходи.

 */

public class exam_exr3 {

	public static void main(String[] args) {
		 
		Scanner input = new Scanner(System.in);
		 
	    int juniorBikers = Integer.parseInt(input.nextLine());
	    int oldBikers = Integer.parseInt(input.nextLine());
	    String trase = input.nextLine();
		 
		
	    switch(trase)
		{
		
		   case "trail" :  
			   double juniorPrice = 5.50;
	           double seniorsPrice = 7;
	 
	           double juniortax = juniorPrice*juniorBikers;
	           double oldTax = seniorsPrice*oldBikers;
	    
	           double allTaxW = juniortax + oldTax;
	           double allTax = allTaxW - (5*allTaxW)/100;
	                   
	           System.out.printf("%.2f", allTax);
	           
	           break;
		
		   case "cross-country" : 
			
			   if((juniorBikers + oldBikers) >= 50)
			   {
				
				   double juniorPrice2 = 8;
				   double seniorsPrice2 = 9.50;
				   
				   double juniorPriceEX = juniorPrice2 - (25*juniorPrice2)/100;
				   double seniorsPriceEX = seniorsPrice2 - (25*seniorsPrice2)/100;
				   
				   double juniortaxEX = juniorPriceEX*juniorBikers;
				   double oldTaxEX = seniorsPriceEX*oldBikers;
			    
				   double allTaxW2 = juniortaxEX + oldTaxEX;
				   double allTax2 = allTaxW2 - (5*allTaxW2)/100;
				   System.out.printf("%.2f",allTax2);
				   
			   }
			   else
			   {
				   
				   double juniorPrice2 = 8;
				   double seniorsPrice2 = 9.50;
			 
				   double juniortax2 = juniorPrice2*juniorBikers;
				   double oldTax2 = seniorsPrice2*oldBikers;
			    
				   double allTaxW2 = juniortax2 + oldTax2;
				   double allTax2 = allTaxW2 - (5*allTaxW2)/100;
				   System.out.printf("%.2f",allTax2);
				   
			   }
			   
			   break;
           
		   case  "downhill" : 
		   
			   double juniorPrice3 = 12.25;
			   double seniorsPrice3 = 13.75;
			 
			   double juniortax3 = juniorPrice3*juniorBikers;
			   double oldTax3 = seniorsPrice3*oldBikers;
			    
			   double allTaxW3 = juniortax3 + oldTax3;
			   double allTax3 = allTaxW3 - (5*allTaxW3)/100;
			   System.out.printf("%.2f",allTax3);
			   
			   break;
	    
		   case "road" : 
			   double juniorPrice4 = 20;
			   double seniorsPrice4 = 21.50;
			 
			   double juniortax4 = juniorPrice4*juniorBikers;
			   double oldTax4 = seniorsPrice4*oldBikers;
			 
			   double allTaxW4 = juniortax4 + oldTax4;
			   double allTax4 = allTaxW4 - (5*allTaxW4)/100;
			   System.out.printf("%.2f",allTax4);
			   
			   break;
		
		}

	}

}
