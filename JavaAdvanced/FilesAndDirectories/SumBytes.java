package FilesAndDirectories;
import java.io.*;

/**
 * Created by na4oy on 3.2.2017 г..
 */
public class SumBytes {
    public static void main(String[] args) throws FileNotFoundException {

        String filePath = "D:\\input.txt";

        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);

        try (BufferedReader reader = new BufferedReader(fileReader)) {
            String line = reader.readLine();
            int sum = 0;
            while(line != null) {
                for (char s : line.toCharArray()) {
                    sum += s;
                }
                line = reader.readLine();
            }
            // I don't know why always first from char array is 65279 ????
           System.out.print(sum );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

