package Matrices;

import java.util.Scanner;

public class FillMatrix {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//Input split
		String[] input = scanner.nextLine().split(", ");
		
		//Matrix size and chosen function
		int matrixSize = Integer.parseInt(input[0]);
		String pattern = input[1].toUpperCase();
		
		int[][] matrix = new int[matrixSize][matrixSize];
		
		int currentNumber = 1; 
		
		//First option
		if(pattern.equals("A"))
		{
			for(int col = 0 ; col < matrixSize; col ++)
			{
				for(int row = 0 ; row <matrixSize ; row++)
				{
					matrix[row][col]=currentNumber;
					currentNumber++;
				}
			}
		}
		// Second oprion
		else if (pattern.equals("B"))
		{
			for(int col = 0 ; col < matrixSize ; col++)
			{
				if(col % 2 == 0	)
				{
					for(int row = 0 ; row < matrixSize ; row++)
					{
						matrix[row][col] = currentNumber;
                        currentNumber++;
					}
				}
				else
				{
					for (int row = matrixSize - 1; row >= 0; row--)
		            {
		                matrix[row][col] = currentNumber;
		                currentNumber++;
		            }
				}
			}
		}
		 // Printing results 
		 for (int row = 0; row < matrixSize; row++)
	        {
	            for (int col = 0; col < matrixSize; col++)
	            {
	                System.out.printf("%d ", matrix[row][col]);
	            }
	            System.out.println();
	        }
		
	}
}
