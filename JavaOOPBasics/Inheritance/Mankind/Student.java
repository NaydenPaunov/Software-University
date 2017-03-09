package Mankind;

/**
 * Created by na4oy on 8.3.2017 г..
 */
public class Student extends Human{
    private String facultyNumber;

    public Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        this.setFacultyNumber(facultyNumber);
    }

    private void setFacultyNumber(String facultyNumber) {
        if(facultyNumber.length() < 5  || facultyNumber.length() > 10 ){
            throw  new IllegalArgumentException("Invalid faculty number!");
        }
        this.facultyNumber = facultyNumber;
    }

    public String getFacultyNumber() {
        return this.facultyNumber;
    }

    @Override
    public String toString() {
        return "First Name: " + super.getFirstName() +"\nLast Name: " + super.getLastName()
                + "\nFaculty number: " + getFacultyNumber();
    }
}
