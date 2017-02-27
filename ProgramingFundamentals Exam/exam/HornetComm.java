package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Struct;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by na4oy on 26.2.2017 г..
 */
public class HornetComm {
    private static List<String> broadcastKey = new ArrayList<>() ;
    private static List<String> broadcastStorage = new ArrayList<>();
    private static List<String> messagesKey = new ArrayList<>() ;
    private static List<String> messagesStorage = new ArrayList<>();

    private static   List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        numbers.add(0);numbers.add(1);numbers.add(2);numbers.add(3);numbers.add(4);
        numbers.add(5);numbers.add(6);numbers.add(7);numbers.add(8);numbers.add(9);

        String input = reader.readLine();
        while (!input.equals("Hornet is Green")){
            String[] firstAndSecondQuery = input.split(" <-> ");
            String firstQuery = firstAndSecondQuery[0];
            String secondQuery = firstAndSecondQuery[1];

            if(isPrivateMassage(firstQuery)){
                if(isValidSecondQuery(secondQuery)){
                    //  System.out.println("private masage");
                    StringBuilder sb = new StringBuilder(firstQuery);
                    sb.reverse();
                    messagesKey.add(sb.toString());
                    messagesStorage.add(secondQuery);
                }
            }else if(isBroadcast(firstQuery)){
                if(isValidSecondQuery(secondQuery)){
                    if(isPrivateMassage(secondQuery)){
                        broadcastKey.add(secondQuery);
                        broadcastStorage.add(firstQuery);
                    }else{
                        broadcastKey.add(changeCase(secondQuery));
                        broadcastStorage.add(firstQuery);
                    }


                }
            }

            input = reader.readLine();
        }

        //Print
        System.out.println("Broadcasts:");
        if(!broadcastKey.isEmpty()) {
            for (int l = 0; l < broadcastStorage.size(); l++) {
                System.out.println(broadcastKey.get(l) + " -> " + broadcastStorage.get(l));
            }
        }else{
            System.out.println("None");
        }

        System.out.println("Messages:");
        if(!messagesKey.isEmpty()) {
            for (int i = 0; i < messagesKey.size(); i++) {
                System.out.println(messagesKey.get(i) + " -> " + messagesStorage.get(i));
            }
        }else{
            System.out.println("None");
        }

    }

    private static String changeCase(String secondQuery) {
        StringBuilder sb = new StringBuilder();

        String lower = secondQuery.toLowerCase();

        String upper = secondQuery.toUpperCase();
        char[] chars = upper.toCharArray();

        for (int i = 0; i < secondQuery.length(); i++) {
            if(secondQuery.charAt(i) == chars[i]){
                sb.append(lower.charAt(i));
            }else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    private static boolean isValidSecondQuery(String secondQuery) {
        Pattern pattern = Pattern.compile("[^0-9A-Za-z]");
        Matcher matcher = pattern.matcher(secondQuery);
        if(matcher.find()){
            return false;
        }else {
            return true;
        }
    }

    private static boolean isBroadcast(String firstQuery) {
        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(firstQuery);

        if(matcher.find()){
            return false;
        }else{
            return true;
        }
    }

    private static boolean isPrivateMassage(String firstQuery) {
        Pattern pattern = Pattern.compile("(\\D+)");
        Matcher matcher = pattern.matcher(firstQuery);

        if(matcher.find()){
            return false;
        }else {
            return true;
        }
    }
}