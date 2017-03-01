package DefiningClassesExr.OpinionPoll;

/**
 * Created by na4oy on 27.2.2017 г..
 */
public class Person {
    private String name;
    private Integer age;

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

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
