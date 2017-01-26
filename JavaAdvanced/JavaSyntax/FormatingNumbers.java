package JavaSyntax;

import java.util.Scanner;

public class FormatingNumbers {

	public static void main(String[] args) {
		
	    Scanner scanner = new Scanner(System.in);
	
	    //Input
	    int firstNum = scanner.nextInt();
	    double secondNum =scanner.nextDouble();
	    double thirdNum = scanner.nextDouble();
	    
	    //Formatting to Hexadecimal and Binary
		String intToHexadecimal = Integer.toHexString(firstNum).toUpperCase();
        String intToBinary = Integer.toBinaryString(firstNum);
        
        //Print Hexadecimal and spaces
        System.out.printf("|%s",intToHexadecimal);
        
        int spaces = 10 - intToHexadecimal.length();
        
        for(int i = 0 ; i < spaces ; i ++)
        {
        	System.out.print(" ");
        }
        
        // Print Binary and zero
        System.out.printf("|");
        int zeroNeeded = 10 - intToBinary.length();
        
        for(int j = 0 ; j < zeroNeeded ; j ++)
        {
        	System.out.print("0");
        
        }
        System.out.printf("%s|",intToBinary);
        
       //Print second number and spaces 
        String strSecondNum = "" + (int)secondNum;
        int  spacesThirdNum = 7 - strSecondNum.length();
        
        if(secondNum < 0 &&(int)secondNum == 0){
        	spacesThirdNum -=1;
        }
        
        for(int t = 0 ; t < spacesThirdNum ; t++)
        {
        	System.out.print(" ");
        }
        
        System.out.printf("%.2f",secondNum);
        
        
        //Print third number and spaces
        System.out.printf("|%.3f",thirdNum);
        
        String strThirdNum = "" + (int)thirdNum;
        int lastSpaces = 6 - strThirdNum.length();
        
        if(thirdNum < 0 && (int)thirdNum == 0){
        	lastSpaces -=1;
        }
		
        for(int g = 0 ; g < lastSpaces ; g++)
		{
			System.out.print(" ");
		}
		
        System.out.print("|");
	}

}
