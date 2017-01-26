package Matrices;

import java.util.Scanner;

public class MatrixOfPalindromes {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//Input split
		String[] input = scanner.nextLine().split(" ");
		
		//Rows and Colons
		int rows = Integer.parseInt(input[0]);
		int cols = Integer.parseInt(input[1]);
	
		char[] alphabet ="abcdefghijklmnopqrstuvwxyz".toCharArray();
		
		String[][] matrix = new String[rows][cols];
	
		
		if(rows < 27 && cols <27)
		{
			//variable needed for colons 
			int a = 0;	
			
			// //Introduce data in the matrix
			for(int row = 0 ; row < rows ; row++)
			{    
				for(int col = 0 ; col < cols ; col++)
				{
					matrix[row][col] = String.valueOf(alphabet[row]) + 
							           String.valueOf(alphabet[col + a]) + 
							           String.valueOf(alphabet[row]);
					
				}
				a++;
			}
			
		}
		else
		{
			System.out.println("Error");
		}
		
		//Print matrix
		for(int row = 0 ; row < rows ; row++)
		{
			for(int col = 0 ; col < cols ; col++)
			{
			System.out.print(matrix[row][col] + " "); 
				
			}
			System.out.println();
		}

	}

}
