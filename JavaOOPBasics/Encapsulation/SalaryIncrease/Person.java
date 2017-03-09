package Encapsulation.SalaryIncrease;

/**
 * Created by na4oy on 1.3.2017 г..
 */
public class Person {
    private String firstName;
    private String lastName;
    private Integer age;
    private Double salary;

    public Person(String firstName, String lastName, Integer age , Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Integer getAge() {
        return this.age;
    }

    public Double getSalary() {
        return this.salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        //Asen Ivanov get 2640.0 leva
        return this.getFirstName() +" " + this.getLastName() +" get " + this.salary + " leva" ;
    }

    public void increaseSalary(Integer bonus) {
       if(this.getAge() > 30){
           this.salary += this.salary * bonus / 100;
       }else {
           this.salary += this.salary * bonus / 200;
       }
    }
}
