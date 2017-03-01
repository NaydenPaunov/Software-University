package DefiningClassesExr.CreatingConstructors;

/**
 * Created by na4oy on 27.2.2017 г..
 */
public class Person {
    public String name;
    public Integer age;

    public Person() {
        this("No name", 1);
    }

    public Person(Integer age) {
        this("No name", age);
    }

    public Person(String name, Integer age) {
        this.age = age;
        this.name = name;
    }
}
