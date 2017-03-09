package Encapsulation.FirstAndReserveTeam;

/**
 * Created by na4oy on 1.3.2017 г.
 */
public class Person {
    private String firstName;
    private String lastName;
    private Integer age;
    private Double salary;

    public Person(String firstName, String lastName, Integer age , Double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
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
        if(salary < 460){
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    public void setFirstName(String firstName) {
        if(firstName.length() < 3){
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if(lastName.length() < 3){
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }

    public void setAge(Integer age) {
        if(age < 0 || age == 0){
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        //Asen Ivanov get 2640.0 leva
        return this.getFirstName() +" " + this.getLastName() +" get " + this.salary + " leva" ;
    }

    public void increaseSalary(Double bonus) {
       if(this.getAge() > 30){
           this.salary += this.salary * bonus / 100;
       }else {
           this.salary += this.salary * bonus / 200;
       }
    }
}
