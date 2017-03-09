package Encapsulation.ValidationData;

import org.jcp.xml.dsig.internal.dom.DOMUtils;

import javax.xml.crypto.dom.DOMCryptoContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by na4oy on 1.3.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            try{
                Person person =new Person(input[0], input[1], Integer.parseInt(input[2]),Double.parseDouble(input[3]));
                persons.add(person);
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
        }

        if(!persons.isEmpty() || persons.size() == n){
            System.out.println("--------------------");
        }

        Double bonus = Double.parseDouble(reader.readLine());
        for (Person person : persons) {
            person.increaseSalary(bonus);
            System.out.println(person.toString());
        }
    }

}
