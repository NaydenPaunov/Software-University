package FilesAndDirectories;

import java.io.*;

/**
 * Created by na4oy on 3.2.2017 г..
 */
public class CountCharacterTypes {
    public static void main(String[] args) {
        String pathIn = "D:\\input.txt";
        String pathOut = "D:\\output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(pathIn));
             PrintWriter writer = new PrintWriter(pathOut)) {

                 int countVowels = 0;
                 int countConsonants = 0;
                 int countPunctuation = 0;

                 String input = reader.readLine();
                 while (input != null){
                     char[] chars = input.toCharArray();
                     for (char ch : chars) {


                         if (ch == 'a' || ch == 'e' || ch == 'i'
                                 || ch == 'o' || ch == 'u') {
                             countVowels++;
                         } else if (ch == '!' || ch == '?' ||
                                 ch == '.' || ch == ',') {
                             countPunctuation++;
                         } else if (ch != ' ' ) {
                             countConsonants++;
                         }
                     }
                     input = reader.readLine();
                 }
                 writer.printf(" Vowels : %d%n Consonants : %d%n punctuation : %d%n",countVowels,countConsonants,countPunctuation);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
