package exams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringJoiner;

/**
 * Created by na4oy on 18.2.2017 г..
 */
public class targetPractice {
    private static String[][] matrix ;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensiosns = reader.readLine().split("\\s+");
        Integer rows = Integer.parseInt(dimensiosns[0]);
        Integer cols = Integer.parseInt(dimensiosns[1]);
        matrix = new String[rows][cols];

        String snake = reader.readLine();

        fillTheMatrix(snake);

        String[] command = reader.readLine().split("\\s+");
        shotMatrix(command);
        gravity();
        printMatrix();
    }

    private static void gravity() {
        for(int i = 0 ; i < matrix[0].length; i++){
            for (int j = matrix.length - 2; j >= 0 ; j--) {
                if(!matrix[j][i].equals(" ")){
                    for (int k = j; k < matrix.length - 1 ; k++) {
                        if(matrix[k +1][i].equals(" ")){
                            matrix[k+1][i] = matrix[k][i];
                            matrix[k][i] = " ";
                        }else{
                            break;
                        }
                    }
                }
            }
        }
    }

    private static void shotMatrix(String[] command) {
        Integer impactRow = Integer.parseInt(command[0]);
        Integer impactCol = Integer.parseInt(command[1]);
        Integer radius = Integer.parseInt(command[2]);
            for (int i = 0; i < matrix.length ; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (Math.pow(i - impactRow, 2) + Math.pow(j - impactCol, 2) <= radius * radius) {
                            matrix[i][j]= " ";
                    }
                }
            }
    }

    private static void printMatrix() {
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[0].length; cols++) {
                System.out.print(matrix[rows][cols]);
            }
            System.out.println();
        }
    }

    private static void fillTheMatrix(String text) {
        StringBuilder snake = new StringBuilder(text);
        Boolean isMovingLeft = true;
        for (int row = matrix.length - 1; row >= 0 ; row--) {
            if(isMovingLeft){
                for (int col = matrix[0].length - 1; col >= 0 ; col--) {
                    matrix[row][col] = String.valueOf(snake.charAt(0));
                    snake.append(matrix[row][col]);
                    snake.deleteCharAt(0);
                }
                isMovingLeft = false;
            }else{
                for (int col = 0; col < matrix[0].length; col++) {
                    matrix[row][col] = String.valueOf(snake.charAt(0));
                    snake.append(matrix[row][col]);
                    snake.deleteCharAt(0);
                }
                isMovingLeft = true;
            }
        }
    }
}
