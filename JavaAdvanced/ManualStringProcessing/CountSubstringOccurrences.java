package ManualStringProcessing;

import java.util.Scanner;

/**
 * Created by na4oy on 6.2.2017 г..
 */
public class CountSubstringOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String searchingWord = scanner.nextLine();

        if (!text.equals(null) && !searchingWord.equals(null)  ) {
            int counter = 0;
            for (int i = 0; i < text.length() - searchingWord.length() + 1; i++) {
                if (text.substring(i, i + searchingWord.length()).toLowerCase().equals(searchingWord.toLowerCase())) {
                    counter++;
                }
            }
            System.out.println(counter);
        }
    }
}
