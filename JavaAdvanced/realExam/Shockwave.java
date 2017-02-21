package realExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by na4oy on 19.2.2017 г..
 */
public class Shockwave {
    private static Integer[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] rowsCols = reader.readLine().split("\\s+");
        Integer rows = Integer.parseInt(rowsCols[0]);
        Integer cols = Integer.parseInt(rowsCols[1]);
        matrix = new Integer[rows][cols];

        initializingMatrix();

        String command = reader.readLine();
        while(!command.equals("Here We Go")){
         String[] tokens = command.split("\\s+");
            Integer upperLeftX1 = Integer.parseInt(tokens[0]);
            Integer upperLeftY1 = Integer.parseInt(tokens[1]);
            Integer bottomRightX2 = Integer.parseInt(tokens[2]);
            Integer bottomRightY2 = Integer.parseInt(tokens[3]);

            addNumber(upperLeftX1,upperLeftY1,bottomRightX2,bottomRightY2);

            command = reader.readLine();
        }

        printMatrix();
    }

    private static void addNumber(Integer upperLeftX1, Integer upperLeftY1, Integer bottomRightX2, Integer bottomRightY2) {
        for (int rows = upperLeftX1; rows <= bottomRightX2 ; rows++) {
            for (int cols = upperLeftY1; cols <= bottomRightY2; cols++) {
                matrix[rows][cols] += 1;
            }
        }
    }



    private static void printMatrix() {
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                System.out.print(matrix[rows][cols] + " ");
            }
            System.out.println();
        }
    }

    private static void initializingMatrix() {
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                matrix[rows][cols] = 0;
            }
        }
    }
}
