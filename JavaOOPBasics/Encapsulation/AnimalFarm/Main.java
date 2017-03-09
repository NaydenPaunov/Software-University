package Encapsulation.AnimalFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by na4oy on 3.3.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine().trim();
        Integer age = Integer.parseInt(reader.readLine().trim());

        try {
            Chicken chicken = new Chicken(name,age);
            System.out.println(chicken.produceEggs());
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}
