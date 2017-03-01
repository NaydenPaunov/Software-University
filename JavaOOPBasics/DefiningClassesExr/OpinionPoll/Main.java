package DefiningClassesExr.OpinionPoll;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.util.TreeMap;

/**
 * Created by na4oy on 27.2.2017 г..
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String,Integer> remainder = new TreeMap<>();

        Integer numberOfLines = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfLines; i++) {
            String[] input = reader.readLine().split(" ");
            String name = input[0];
            Integer age = Integer.parseInt(input[1]);
            Person person = new Person(name,age);

            if(person.getAge() > 30){
                remainder.put(person.getName(),person.getAge());
            }
        }
        for (String key : remainder.keySet()) {
            System.out.println(key + " - " + remainder.get(key));
        }

    }
}


