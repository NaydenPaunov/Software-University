package Matrices;

import java.util.Scanner;

public class DiagonalDifference {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = Integer.parseInt(scanner.nextLine());
		
		
		
		//Create and Introduce data in the matrix
		int[][] matrix = new int[n][n];
		
		for(int row = 0 ; row < matrix.length ; row++)
		{
			String[] input = scanner.nextLine().split(" ");
			
			for(int col = 0 ; col < matrix[row].length ; col++)
			{
				matrix[row][col] = Integer.parseInt(input[col]);
			}
		}

		//Left diagonal sum
		int leftDiagonalSum = 0;
		for(int d1 = 0; d1 < n ; d1++)
		{
			leftDiagonalSum += matrix[d1][d1] ;
		}
		
		//Right diagonal Sum
		int rowNeeded = 0;
		int rightDiagonalSum = 0;
		for(int d2 = n-1 ; d2 >= 0 ; d2--)
		{
	    	rightDiagonalSum += matrix[d2][rowNeeded] ;
	    	rowNeeded++;	
		}
		
		// Calculate and Print difference between diagonals 
		int difference = leftDiagonalSum - rightDiagonalSum;
		if(difference < 0)
		{
			difference *= -1;
		}
		System.out.println(difference);
		
	}

}
