package FilesAndDirectories;
import java.io.*;

/**
 * Created by na4oy on 3.2.2017 г..
 */
public class test {
    private static final String path = "/src/FilesAndDirectories/testt.txt";
    public static void main(String[] args) throws FileNotFoundException {
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + path;

        File someFile = new File(filePath);
        FileReader fileReader = new FileReader(someFile);

        try (BufferedReader reader = new BufferedReader(fileReader)){

            String line;
            while ((line = reader.readLine()) != null){
                long sum = 0 ;
                for (char c : line.toCharArray()) {
                sum +=c;

                }
                System.out.println(sum);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
