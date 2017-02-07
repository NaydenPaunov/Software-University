package FilesAndDirectories;

import java.io.*;
import java.util.HashMap;
import java.lang.Integer;
import java.lang.String;
import static java.lang.String.format;

/**
 * Created by na4oy on 3.2.2017 г..
 */
public class WordCount {
    private  static final String PROJECT_PATH = System.getProperty("user.dir") + "/src/resources/";
    private  static final String WORD_FILE_PATH = PROJECT_PATH + "words.txt";
    private  static final String TEST_FILE_PATH = PROJECT_PATH + "text.txt";
    private  static final String RESULT_FILE_PATH = PROJECT_PATH + "results.txt";

    public static void main(String[] args) throws IOException {

        HashMap<String,Integer> wordsCount = new HashMap<>();
        HashMap<String,String> originalWord = new HashMap<>();

        try(BufferedReader wordsReader = new BufferedReader(new FileReader(WORD_FILE_PATH));
            BufferedReader textReader = new BufferedReader(new FileReader(TEST_FILE_PATH));
            BufferedWriter writer = new BufferedWriter(new FileWriter(RESULT_FILE_PATH))) {

            String line;
            while ((line = wordsReader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    String wordKey = word.toLowerCase();
                    if (!wordsCount.containsKey(wordKey)) {
                        wordsCount.put(word, 0);
                        originalWord.put(wordKey, word);
                    }
                }
            }

            while ((line = textReader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    String wordKey = word.toLowerCase();
                    if (wordsCount.containsKey(wordKey)) {
                        String key = wordKey;
                        int count = wordsCount.get(key) + 1;
                        wordsCount.put(key, count);
                    }
                }
            }


            wordsCount.entrySet().stream().sorted((e1, e2) -> e2.getValue()
                    .compareTo(e1.getValue())).forEach(pair -> {
                try {
                    writer.write(String.format("%s %d", originalWord.get(pair.getKey()), pair.getValue()));
                    writer.newLine();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
