package Matrices;

import java.util.Scanner;

public class maximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        //Input colons and rows
        String[] input = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        //Introduce data in the matrix 
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] numsStr = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(numsStr[col]);
            }
        }
   
        //Searching max element 3 x 3 matrix
        int maxSum = Integer.MIN_VALUE;
        int startRow = 0;
        int startCol = 0;
                
        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int tempSum = 0;
                for (int subRow = row; subRow < row + 3; subRow++) {
                    for (int subCol = col; subCol < col + 3; subCol++) {
                        tempSum += matrix[subRow][subCol];
                       
                    }
                
                }
                
                if (tempSum > maxSum) {
                    maxSum = tempSum;
                    startRow = row;
                    startCol = col;
                }
            }
        }
        
        //Print
        System.out.printf("Sum = %d%n", maxSum);

        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}