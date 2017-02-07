package ManualStringProcessing;

import java.util.Scanner;

/**
 * Created by na4oy on 6.2.2017 г..
 */
public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(scanner.nextLine());
        System.out.println(sb.reverse());
    }
}
