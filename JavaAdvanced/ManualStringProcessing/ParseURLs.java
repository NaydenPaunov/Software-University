package ManualStringProcessing;

import java.util.Scanner;

/**
 * Created by na4oy on 6.2.2017 г..
 */
public class ParseURLs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("://");

        //We can not hava :// twice
        if(input.length != 2){
            System.out.println("Invalid URL");
        }else{
            //Format and Print
            System.out.println(String.format("Protocol = %s",input[0]));
            int index = input[1].indexOf('/');
            String server = String.format("Server = %s",input[1].substring(0,index));
            System.out.println(server);
            String resources =String.format("Resources = %s",input[1].substring(index + 1));
            System.out.println(resources);
        }



    }
}
