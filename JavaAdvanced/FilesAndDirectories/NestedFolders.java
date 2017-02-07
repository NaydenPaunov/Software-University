package FilesAndDirectories;

import java.io.File;
import java.util.ArrayDeque;

/**
 * Created by na4oy on 3.2.2017 г..
 */
public class NestedFolders {
    public static void main(String[] args) {

        final String stringPath = "D:\\Files-and-Streams";
        File file = new File(stringPath);

        ArrayDeque<File> queue = new ArrayDeque<>();
        queue.offer(file);

        int counter = 1;
        while (!queue.isEmpty()){
            File currentDir = queue.poll();
            
            File[] nestedFiles = currentDir.listFiles();
            for (File nestedFile : nestedFiles) {
                if(nestedFile.isDirectory()){
                    queue.offer(nestedFile);
                    counter++;
                }
            }
            System.out.println(currentDir.getName());
        }
        System.out.println(counter + " folders");
    }
}
