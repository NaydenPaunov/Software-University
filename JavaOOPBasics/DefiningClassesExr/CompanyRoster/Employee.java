package DefiningClassesExr.CompanyRoster;

/**
 * Created by na4oy on 27.2.2017 г..
 */
public class Employee {
    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private Integer age;

    Employee(String name, double salary, String position, String department, String email, Integer age) {
        this.setName(name);
        this.setSalary(salary);
        this.setPosition(position);
        this.setDepartment(department);
        this.setAge(age);
        this.setEmail(email);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    private void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    private void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        if (email == null) {
            this.email = "n/a";
            return;
        }
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    private void setAge(Integer age) {
        if (age == null) {
            this.age = -1;
            return;
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", this.getName(), this.getSalary(), this.getEmail(), this.getAge());
    }
}
