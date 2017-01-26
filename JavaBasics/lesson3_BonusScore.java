package ProgramiBasics;

import java.util.Scanner;

public class lesson3_BonusScore {

	public static void main(String[] args) {
		
      Scanner input = new Scanner(System.in);
      
      double number = input.nextInt();
      double score = 0.0;
      
      if( number <= 100)
      {
    	  	score +=5;
      }
      else if(number <= 1000)
      {
    	  score = number * 20 / 100;
      }
      else if( number > 1000)
      {
    	  score = number * 10 / 100;
      }
      
      if(number % 2 == 0)
      {
    	  score += 1;
      }
      if(number % 10 == 5)
      {
    	  score += 2;
      }
      
      System.out.println(score);
      System.out.println(score + number);
		
	}

}
