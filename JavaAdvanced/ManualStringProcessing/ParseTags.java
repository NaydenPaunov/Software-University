package ManualStringProcessing;

import java.util.Scanner;

/**
 * Created by na4oy on 6.2.2017 г..
 */
public class ParseTags {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String upCaseOpen = "<upcase>";
        String upCaseClose = "</upcase>";

        while (input.indexOf(upCaseOpen) != -1){
            if(input.equals(null)){
                break;
            }
            int openIndex = input.indexOf(upCaseOpen);
            int closeIndex = input.indexOf(upCaseClose);

            String subString = input.substring(openIndex + upCaseOpen.length(),closeIndex);
            input = input.replace(upCaseOpen + subString + upCaseClose ,subString.toUpperCase() );

        }
        System.out.println(input);

    }
}
