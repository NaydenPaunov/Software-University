package javaBasics;

import java.util.Scanner;
/*
Задача 6. Максимален брой комбинации
Да се напише програма, която отпечатва всички възможни комбинации с двойки числа от даден интервал с начало и 
край, които се четат от конзолата. От конзолата се чете и още едно число, което показва максималният брой комбинаци, които
могат да се изпечатат. Ако комбинациите достигнат този брой, програмата трябва да приключи.

Примерен вход и изход:
69
71         <69-69><69-70><69-71><70-69><70-70><70-71><71-69><71-70><71-71>
100	

1          
4          <1-1><1-2><1-3><1-4><2-1>
5
	
*/

public class exam_exr6 {

	public static void main(String[] args) {
		
		 Scanner input = new Scanner(System.in);
		 
		 int Start = Integer.parseInt(input.nextLine());
		 int End = Integer.parseInt(input.nextLine());
		 int MaxNumber = Integer.parseInt(input.nextLine());
		 int N = 0;
		 
		 while(N < MaxNumber)
		 {
			 for(int i = Start ; i <= End ; i++)
			 {
				 for (int j = Start ; j <= End ; j++)
				 {   N +=1;
				     if(N <= MaxNumber){
					 System.out.printf("<%d-%d>", i,j);
				     }
				     if(i == End && j == End)
				     {
				    	 N = MaxNumber;
				     }
				 }
				
			 }
		 }
	}

}
