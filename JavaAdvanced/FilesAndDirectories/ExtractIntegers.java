package FilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by na4oy on 3.2.2017 г..
 */
public class ExtractIntegers {
    public static void main(String[] args) {
        String inputPath = "D:\\input.txt";
        String outputPath = "D:\\output.txt";

        try (Scanner scanner = new Scanner(new FileInputStream(inputPath));
             PrintWriter writer = new PrintWriter(outputPath)){
          while (scanner.hasNext()){
              if(scanner.hasNextInt()){
                  writer.println(scanner.nextInt());
              }
              scanner.next();
          }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
