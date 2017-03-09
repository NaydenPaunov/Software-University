package Mankind;

/**
 * Created by na4oy on 8.3.2017 г..
 */
public class Worker extends  Human{
    private Double weekSalary;
    private Double workHoursPerDay;

    public Worker(String firstName, String lastName, Double weekSalary, Double workHoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    public Double getWeekSalary() {
        return this.weekSalary;
    }

    public Double getWorkHoursPerDay() {
        return this.workHoursPerDay;
    }

    public Double getSalaryPerHour(){
        return getWeekSalary()/(getWorkHoursPerDay()*7);
    }

    private void setWeekSalary(Double weekSalary) {
        if(weekSalary < 10){
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    private void setWorkHoursPerDay(Double workHoursPerDay) {
        if(workHoursPerDay < 1 || workHoursPerDay > 12){
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHoursPerDay = workHoursPerDay;
    }


    @Override
    public String toString() {
        return String.format("First Name: %s%nLast Name: %s%nWeek Salary: %.2f%nHours per day: %.2f%nSalary per hour: %.2f"
                         ,super.getFirstName(),super.getLastName(),getWeekSalary(),getWorkHoursPerDay(),getSalaryPerHour());
    }
}
