package Inheritance.Person;

/**
 * Created by na4oy on 8.3.2017 г..
 */
public class Child extends  Person{

    public Child(String name, Integer age) {
        super(name, age);
    }

    @Override
    protected void setAge(Integer age) {
        if(age >= 15){
            throw new IllegalArgumentException("Child's age must be lesser than 15!");
        }
        super.setAge(age);
    }
}
