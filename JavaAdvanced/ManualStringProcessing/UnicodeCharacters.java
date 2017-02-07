package ManualStringProcessing;

import java.util.Scanner;

/**
 * Created by na4oy on 7.2.2017 г..
 */
public class UnicodeCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder("");

        for (char c : input.toCharArray()) {
            String hexFormat = Integer.toString((int) c, 16);
            int hexlength = hexFormat.length();
            while (hexlength < 4) {
                hexFormat = '0' + hexFormat;
                hexlength = hexFormat.length();
            }
            sb.append(String.format("\\u%s", hexFormat));
        }
        System.out.println(sb);
    }
}
