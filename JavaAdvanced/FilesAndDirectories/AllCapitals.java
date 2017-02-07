package FilesAndDirectories;

import java.io.*;

/**
 * Created by na4oy on 3.2.2017 г..
 */
public class AllCapitals {
    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "D:\\input.txt";
        String outPath = "D:\\output.txt";
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);


        try (BufferedReader reader = new BufferedReader(fileReader);
             FileWriter writer = new FileWriter(outPath)) {

            String input = reader.readLine();
            while(input != null){
                writer.write(input.toUpperCase());
                input = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
