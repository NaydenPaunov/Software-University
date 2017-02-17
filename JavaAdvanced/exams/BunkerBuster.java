package exams;

import com.sun.javafx.image.IntPixelGetter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by na4oy on 16.2.2017 г..
 */
public class BunkerBuster {
    private static Integer[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] rowsCols = reader.readLine().split(" ");
        Integer rows = Integer.parseInt(rowsCols[0]);
        Integer cols = Integer.parseInt(rowsCols[1]);
        matrix = new Integer[rows][cols];

        readMatrix(reader);
        String command = reader.readLine();
        while (!command.equals("cease fire!")){
            String[] tokens = command.split(" ");
            Integer impactRow = Integer.parseInt(tokens[0]);
            Integer impactCol = Integer.parseInt(tokens[1]);
            String power = tokens[2];

            commandExecute(impactRow,impactCol,power);
            command = reader.readLine();
        }
        Integer celsDestryed  = celDestryed();
        Double damageDone = 100.0 * celsDestryed / (rows * cols);
        System.out.println("Destroyed bunkers: " + celsDestryed);
        System.out.println("Damage done: " + String.format("%.1f",damageDone) + " %");

    }

    private static int celDestryed() {
        Integer count = 0 ;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if(matrix[row][col] <= 0 ){
                    count += 1;
                }
            }
        }
        return  count;
    }

    private static void commandExecute(Integer impactRow, Integer impactCol, String power) {
        Integer damage = (int)power.charAt(0);
        cellDamage(impactRow,impactCol,damage);
        if(damage % 2 == 0){
            damage = damage / 2;
        }else{
            damage = damage / 2 + 1;
        }
        cellDamage(impactRow +1,impactCol,damage);
        cellDamage(impactRow+ 1,impactCol+ 1,damage);
        cellDamage(impactRow,impactCol + 1,damage);
        cellDamage(impactRow - 1,impactCol,damage);
        cellDamage(impactRow,impactCol - 1,damage);
        cellDamage(impactRow - 1,impactCol - 1,damage);
        cellDamage(impactRow - 1,impactCol + 1,damage);
        cellDamage(impactRow + 1,impactCol - 1,damage);

    }

    private static void cellDamage(Integer impactRow, Integer impactCol, Integer damege) {
        try {
            matrix[impactRow][impactCol] -= damege;
        }catch (IndexOutOfBoundsException ex){ }
    }

    private static void readMatrix(BufferedReader reader) throws IOException {
        for (Integer rows = 0; rows < matrix.length ;  rows++) {
            String[] remainder = reader.readLine().split(" ");
            for (Integer cols = 0; cols < remainder.length ; cols++) {
                matrix[rows][cols] = Integer.parseInt(remainder[cols]);
            }
        }
    }
}
