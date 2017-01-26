package JavaSyntax;

import java.util.Scanner;

public class OddAndEvenPairs {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String numbers = scanner.nextLine();
		
		String[] arrayOfNumbers = numbers.split(" ");
	    
		int arrayLength = arrayOfNumbers.length;
		
		// Check for correct array length
		if(arrayLength % 2 == 0)
		{
		   String[] EvenOrOdd = new String[arrayOfNumbers.length];
			 
		   //Check even or odd and save it in an array
           for(int i = 0 ; i < arrayLength; i ++)
           {
        	  int num = Integer.parseInt(arrayOfNumbers[i]);
        	  
        	  if(num % 2 == 0)
              {
        		  EvenOrOdd[i]="Even";
        	  }
        	  else
        	  {
        		  EvenOrOdd[i]="Odd";
        	  }
           }
           
           // Printing the results 
           for(int j = 0 ; j <= arrayLength/2+1 ; j+=2)
           {
        	   if(EvenOrOdd[j] =="Even" &&  EvenOrOdd[j+1] == "Even")
        	   {
        		   System.out.printf("%s, %s -> both are even%n",arrayOfNumbers[j],arrayOfNumbers[j+1]);
        	   }
        	   else if (EvenOrOdd[j]=="Odd" && EvenOrOdd[j+1]=="Odd")
        	   {
        		   System.out.printf("%s, %s -> both are odd%n",arrayOfNumbers[j],arrayOfNumbers[j+1]);
        	   }
        	   else
        	   {
        		  System.out.printf("%s, %s -> different%n",arrayOfNumbers[j],arrayOfNumbers[j+1]);
        	   }
           }
           
           
           
			
		}
		else
		{
			System.out.println("invalid length");
		}

	}

}
