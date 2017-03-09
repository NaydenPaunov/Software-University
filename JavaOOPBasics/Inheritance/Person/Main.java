package Inheritance.Person;

import java.util.Scanner;

/**
 * Created by na4oy on 8.3.2017 г..
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        Integer age = Integer.valueOf(scanner.nextLine());

        try {
            Child child = new Child(name, age);

            System.out.println(child.toString());

            String personClassName = Person.class.getSimpleName();

            String childClassName = Child.class.getSimpleName();

        } catch (IllegalArgumentException error) {

            System.out.println(error.getMessage());

        }
    }
}
