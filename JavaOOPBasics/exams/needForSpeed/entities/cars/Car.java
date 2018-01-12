package needForSpeed.entities.cars;

import com.sun.scenario.effect.impl.prism.PrImage;

public abstract class Car {
    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;


    protected Car (String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.setHorsepower(horsepower);
        this.acceleration = acceleration;
        this.setSuspension(suspension);
        this.durability = durability;
    }

    public void tuneCar(int index, String addOn) {
        this.horsepower += index;
        this.suspension += ((index * 50) / 100);
    }


    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public int getSuspension() {
        return suspension;
    }

    public int getDurability() {
        return durability;
    }

    protected void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    protected void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
                .append(String.format("%s %s %d", this.getBrand(), this.getModel(), this.getYearOfProduction()))
                .append(System.lineSeparator())
                .append(String.format("%d HP, 100 m/h in %d s", this.getHorsepower(), this.getAcceleration()))
                .append(System.lineSeparator())
                .append(String.format("%d Suspension force, %d Durability", this.getSuspension(), this.getDurability()))
                .append(System.lineSeparator());
        return sb.toString();
    }
}
