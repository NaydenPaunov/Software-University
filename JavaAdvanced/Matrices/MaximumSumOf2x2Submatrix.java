package Matrices;

import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {

	public static void main(String[] args) {
	   
		Scanner scanner = new Scanner(System.in);
		
		//Input matrix length
		String[] length = scanner.nextLine().split(", ");
		
	    int[][] matrix = new int[Integer.parseInt(length[0])][Integer.parseInt(length[1])];
		
		//Introduce data in the matrix
		for(int row = 0 ; row < matrix.length ; row++)
		{  
			String[] remainder = scanner.nextLine().split(", ");
			
			for(int col = 0 ; col < matrix[row].length; col ++)
			{
				matrix[row][col] = Integer.parseInt(remainder[col]);
			}
		}
		
      int sumMax = Integer.MIN_VALUE;
      int rowStar = 0;
      int colStar = 0 ;
      
      //Searching the max sum of 2x2 sub matrix
      for(int row = 0 ; row < matrix.length - 1 ; row++)
      {
    	  for(int col = 0 ; col < matrix[row].length - 1 ; col++)
    	  {
    		  int currentSum = matrix[row][col] + 
    				  matrix[row +1][col] + 
    				  matrix[row][col + 1] +
    				  matrix[row + 1][col + 1] ;
    		  
    		  if(currentSum > sumMax)
    		  {
    			  sumMax = currentSum;
    			  rowStar = row;
    			  colStar = col;
    		  }  		  
    	  }
      }
      
      //Printing results
      System.out.println(matrix[rowStar][colStar] + " " + matrix[rowStar][colStar +1]);
      System.out.println(matrix[rowStar + 1][colStar] + " " + matrix[rowStar + 1][colStar +1]);
      System.out.println(sumMax);
      
	}

}
