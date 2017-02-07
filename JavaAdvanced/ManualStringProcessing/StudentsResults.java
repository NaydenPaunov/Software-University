package ManualStringProcessing;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by na4oy on 6.2.2017 г..
 */
public class StudentsResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String,List<Double>> results = new TreeMap<>();

        for (int i = 0; i < n ; i++) {
            //Split input
            String[] input = scanner.nextLine().split(" - ");
            String[] examResultsString = input[1].split(", ");

            //Parse to double and add to list
            List<Double> examResults = new ArrayList<>();
            double sum = 0 ;
            for (String examResult : examResultsString) {
                double remainder = Double.parseDouble(examResult);
                sum += remainder;
                examResults.add(remainder);
            }

            examResults.add(sum / 3);
            results.put(input[0],examResults);
        }
        //Print Results
        if(n != 0) {
            System.out.println(String.format("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|", "Name", "JAdv", "JavaOOP", "AdvOOP", "Average"));
        }
        for (String s : results.keySet()) {
            System.out.println(String.format("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|",s,
                    results.get(s).get(0),results.get(s).get(1),results.get(s).get(2),
                    results.get(s).get(3)).replace(".",","));
        }


    }
}
