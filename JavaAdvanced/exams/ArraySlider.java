package exams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by na4oy on 16.2.2017 г..
 */
public class ArraySlider {
    private static List<BigInteger> list = new ArrayList<>();
    private static int currentIndex = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");

        for (String s : input) {
            list.add(new BigInteger(s));
        }

        String command = reader.readLine();
        while (!command.equals("stop")){
            String[] remainder = command.split("\\s+");
            int offset = Integer.parseInt(remainder[0]);
            String opperation  = remainder[1];
            BigInteger operand = new BigInteger(remainder[2]);

            findIndex(offset);
            operationExsecute(opperation , operand);

            command = reader.readLine();
        }
        System.out.println(list);
    }

    private static void operationExsecute(String opperation, BigInteger operand) {
        switch (opperation){
            case "&" :
                list.set(currentIndex , list.get(currentIndex).and(operand));
                break;
            case "|" :
                list.set(currentIndex, list.get(currentIndex).or(operand));
                break;
            case "^" :
                list.set(currentIndex, list.get(currentIndex).xor(operand));
                break;
            case "+" :
                list.set(currentIndex , list.get(currentIndex).add(operand));
                break;
            case "-" :
                if(list.get(currentIndex).subtract(operand).compareTo(BigInteger.ZERO) == -1){
                    list.set(currentIndex,BigInteger.ZERO);
                }else{
                    list.set(currentIndex, list.get(currentIndex).subtract(operand));
                }

                break;
            case "*" :
                list.set(currentIndex, list.get(currentIndex).multiply(operand));
                break;
            case "/" :
                list.set(currentIndex, list.get(currentIndex).divide(operand));
                default:
                    break;
        }
    }

    private static void findIndex(int offset) {
        currentIndex += offset;
        if(currentIndex % list.size() >= 0){
            currentIndex = currentIndex % list.size();
        }else {
            currentIndex = list.size() + currentIndex % list.size();
        }
    }
}
