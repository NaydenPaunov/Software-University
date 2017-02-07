package ManualStringProcessing;

import javafx.beans.binding.StringBinding;

import java.util.Scanner;

/**
 * Created by na4oy on 6.2.2017 г..
 */
public class StringLength {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String s = "*";
        StringBuilder sb = new StringBuilder();
        if(input.length() <= 20) {
            sb.append(new String(new char[20 - input.length()]).replace("\0", s));
            System.out.println(input + sb);
        }else{
            for (int i = 0; i < 20; i++) {
                sb.append(input.charAt(i));
            }
            System.out.println(sb);
        }

    }
}
