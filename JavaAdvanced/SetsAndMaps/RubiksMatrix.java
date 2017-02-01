package SetsAndMaps;

import java.util.Scanner;

public class RubiksMatrix {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] rowsCols = scanner.nextLine().split(" ");

		int[][] matrix = new int[Integer.parseInt(rowsCols[0])][Integer.parseInt(rowsCols[1])];
		InicializeTheMatrix(matrix);
	 
		int n = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < n; i++) {
			String[] command = scanner.nextLine().split(" ");
			MoveRowsCols(command, matrix);
		}
		
		RearangeTheMatrix(matrix);
		
	}


public static void RearangeTheMatrix(int[][] matrix) {
	StringBuilder sb = new StringBuilder();

	System.out.println(sb.toString());
}

public static void InicializeTheMatrix(int[][] matrix) {
    int sum = 0;
    for (int row = 0; row < matrix.length; row++) {
        for (int col = 0; col < matrix[row].length; col++) {
            matrix[row][col] = ++sum;
        }
    }
}

public static void MoveRowsCols(String[] command, int[][] matrix) {
    int col = Integer.parseInt(command[0]);
    int row = Integer.parseInt(command[2]);
    int oldRow = row;
    int oldCol = col;

    int buffer = matrix[row][col];
    switch (command[1]) {
        case "up": {
            row--;
        }
        break;
        case "down": {
            row++;
        }
        break;
        case "left": {
            col--;
        }
        break;
        case "right": {
            col++;
        }
        break;
    }

    try {
        int a = matrix[oldRow][oldCol];
        int b = matrix[row][col];
        matrix[oldRow][oldCol] = matrix[row][col];
        matrix[row][col] = buffer;
    } catch (IndexOutOfBoundsException e) {
        //Do nothing
    }
}

}