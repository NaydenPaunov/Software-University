package ManualStringProcessing;

import java.util.Scanner;

/**
 * Created by na4oy on 6.2.2017 г..
 */
public class FormattingNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int a = Integer.parseInt(input[0]);
        double b = Double.parseDouble(input[1]);
        double c = Double.parseDouble(input[2]);

        String HexadecimalStrA = Integer.toHexString(a);
        String binaryStringA = Integer.toBinaryString(a);

       while(binaryStringA.length() < 10){
           binaryStringA = "0" + binaryStringA;
       }
       if(binaryStringA.length() > 10){
           binaryStringA = binaryStringA.substring(0,10);
       }

       StringBuilder sb = new StringBuilder();
       sb.append("|").append(String.format("%-10X",a));
       sb.append("|").append(String.format("%s",binaryStringA));
       sb.append("|").append(String.format("%10.2f", b));
       sb.append("|").append(String.format("%-10.3f",c));
       sb.append("|");

        System.out.println(sb);
    }
}
