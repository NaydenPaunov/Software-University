package FilesAndDirectories;

import java.io.*;

/**
 * Created by na4oy on 3.2.2017 г..
 */
public class LineNumbers {
    public static void main(String[] args) {
        String pathIn = "D:\\input.txt";
        String pathOut = "D:\\output.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(pathIn));
            PrintWriter writer = new PrintWriter(pathOut)) {

            String input = reader.readLine();
            int i = 1;
            while(input != null) {
                writer.printf("%d. %s%n",i,input);
                input = reader.readLine();
                i++;

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
