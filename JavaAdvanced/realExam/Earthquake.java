package realExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.util.*;

/**
 * Created by na4oy on 19.2.2017 г..
 */
public class Earthquake {
    private static  Deque<Integer[]> queue = new ArrayDeque<>();
    private static  StringBuilder sb = new StringBuilder();
    private static  Integer count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(reader.readLine());

        String[] lines = new String[n];
        for (int i =0; i < n ; i++) {
            lines[i] = reader.readLine();
        }

        for (int j = 0; j < lines.length; j++) {
            String[] numberStr = lines[j].split(" ");
            Integer[] numbers = new Integer[numberStr.length];
            for (int i = 0; i <numberStr.length ; i++) {
                numbers[i] = Integer.parseInt(numberStr[i]);
            }
            queue.add(numbers);
        }

        seismicitiesLogic();
        System.out.println(count);
        System.out.println(sb.toString());
    }
    private static void seismicitiesLogic() {
        while (queue.size() != 0){
            count++;
            Integer[] numbers = queue.poll();
            //add all nums in queue
            ArrayDeque<Integer> numQueue = new ArrayDeque<>();
            for (int i = 0; i < numbers.length; i++) {
                numQueue.add(numbers[i]);
            }

            Integer firstElement = numQueue.poll();
            sb.append(firstElement).append(" ");
            for (int j = 0; j < numQueue.size(); j++) {

                if(firstElement >= numQueue.peek() && numQueue.size() != 0){
                    numQueue.poll();
                }else{
                    Integer[] num = new Integer[numQueue.size()];
                    for (int i = 0; i <= numQueue.size(); i++) {
                        num[i] = numQueue.poll();
                    }
                    queue.addLast(num);
                }
                //??
                if(numQueue.size() == 1){
                    Integer[] num = new Integer[numQueue.size()];
                    for (int i = 0; i <= numQueue.size(); i++) {
                        num[i] = numQueue.poll();
                    }
                    queue.addLast(num);
                }

            }

        }


    }
}




