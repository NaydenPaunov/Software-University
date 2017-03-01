package StaticIdAndInterestRate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by na4oy on 24.2.2017 г..
 */
public class Person {
    private String name ;
    private Integer age ;
    private List<Main.BankAccount> accounts;

    public Person(String name , Integer age) {
      this(name , age , new ArrayList<>());
    }

    public Person(String name , Integer age , List<Main.BankAccount> accounts){
       this.name = name;
       this.age = age;
       this.accounts = accounts;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}

