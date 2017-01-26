package Matrices;

import java.util.Scanner;

public class SumMatrixElements {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//Input length
		String[] input = scanner.nextLine().split(", ");
		
		//Matrix
		int[][] numbers = new int[Integer.parseInt(input[0])][Integer.parseInt(input[1])];
		
		////Introduce data in the matrix
		for(int row = 0 ; row < numbers.length;row++)
		{
			String[] reminder = scanner.nextLine().split(", ");
			for(int col = 0 ; col < numbers[row].length; col++)
			{
				numbers[row][col]=Integer.parseInt(reminder[col]);
			}			
		}
		
		//Calculate the sum of matrix elements
		int sum = 0;
		for(int[] number : numbers)
		{
			for(int i : number)
			{
				sum +=i;
			}
		}
		
		System.out.println(numbers.length);
		System.out.println(numbers[0].length);
		System.out.println(sum);
		
	}

}
