package FilesAndDirectories;

import java.io.File;

/**
 * Created by na4oy on 3.2.2017 г..
 */
public class ListFiles {
    public static void main(String[] args) {
        final String stringPath = "D:\\Files-and-Streams";
        File file = new File(stringPath);

        if(file.isDirectory()){
            File[] files = file.listFiles();

            for (File f : files) {
                if(!f.isDirectory()){
                    System.out.printf("%s: %s%n",f.getName(),f.length());
                }
            }
        }
    }
}
