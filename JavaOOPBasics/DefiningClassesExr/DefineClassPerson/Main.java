package DefiningClassesExr.DefineClassPerson;

import java.lang.reflect.Field;

/**
 * Created by na4oy on 27.2.2017 г..
 */
public class Main {
    public static void main(String[] args) {
    Class person  = Person.class;

        Field[] fields = person.getDeclaredFields();
        System.out.println(fields.length);
    }

}
