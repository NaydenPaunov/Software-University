package JavaSyntax;

import java.util.Scanner;

public class HitTheTarget {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//Input
		int number = Integer.parseInt(scanner.nextLine());
		
		for(int i = 1; i <= 20 ; i++)
		{
			for(int j = 1; j <=20; j++)
			{
				int firstCondition = i + j;
				int secondCondition = i - j;
				
				if(firstCondition == number)
				{
					System.out.printf("%d + %d = %d%n",i,j,number);
				}
				else if(secondCondition == number)
				{
					System.out.printf("%d - %d = %d%n",i,j,number);	
				}
				
			}
		}
		
	}
}
