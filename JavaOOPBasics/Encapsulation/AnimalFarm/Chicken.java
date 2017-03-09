package Encapsulation.AnimalFarm;

/**
 * Created by na4oy on 3.3.2017 г..
 */
public class Chicken {
    private String name;
    private Integer years;

    public Chicken(String name, Integer years) {
        this.setName(name);
        this.setYears(years);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name.isEmpty() || name.equals(" ") ){
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    public Integer getYears() {
        return this.years;
    }

    private void setYears(Integer years) {
        if(years >= 15 || years < 1){
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.years = years;
    }

    public String produceEggs(){
        if(this.getYears() < 6 ){
            return "Chicken "+ this.getName() +" (age "+ this.getYears() + ") can produce 2 eggs per day.";
        }else if(this.getYears() >= 6 && this.getYears() <  12 ){
            return  "Chicken "+ this.getName() +" (age "+ this.getYears() + ") can produce 1 eggs per day.";
        }else {
            return  "Chicken "+ this.getName() +" (age "+ this.getYears() + ") can produce 0.75 eggs per day.";
        }
    }
}