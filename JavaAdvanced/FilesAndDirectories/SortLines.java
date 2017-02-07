package FilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by na4oy on 3.2.2017 г..
 */
public class SortLines {
    public static void main(String[] args) {

        String inputPath = "D:\\input.txt";
        String outputPath = "D:\\output.txt";

        Path pathIn = Paths.get(inputPath);
        Path pathOut = Paths.get(outputPath);

        try {
           List<String> list = Files.readAllLines(pathIn);
            Collections.sort(list);
            Files.write(pathOut,list);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
