package ManualStringProcessing;

import java.util.*;

/**
 * Created by na4oy on 7.2.2017 г..
 */
public class Palindromes {
    public static void main(String[]   args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] words = input.split("[!?,.\\s+]");

        ArrayDeque<String> queue = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (!word.equals("")) {
                sb.append(word);
                sb.reverse();
                if (sb.toString().equals(word) && !queue.contains(word)) {
                    queue.addFirst(word);
                }
                sb.setLength(0);
            }
        }

            System.out.println(queue.toString());

    }
}
