package DefiningClassesExr.CreatingConstructors;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;

/**
 * Created by na4oy on 27.2.2017 г..
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Class personClass = Person.class;

        Constructor emptyCtor = personClass.getDeclaredConstructor();

        Constructor ageCtor = personClass.getDeclaredConstructor(Integer.class);

        Constructor nameAgeCtor = personClass.getDeclaredConstructor(String.class, Integer.class);

        String name = reader.readLine();
        int age = Integer.parseInt(reader.readLine());

        Person basePerson = (Person) emptyCtor.newInstance();

        Person personWithAge = (Person) ageCtor.newInstance(age);

        Person personFull = (Person) nameAgeCtor.newInstance(name, age);

        System.out.printf("%s %s%n", basePerson.name, basePerson.age);
        System.out.printf("%s %s%n", personWithAge.name, personWithAge.age);
        System.out.printf("%s %s%n", personFull.name, personFull.age);
    }
}


