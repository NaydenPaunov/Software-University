package needForSpeed.entities.cars;

public abstract class Car {
    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;

    Car(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.setHorsepower(horsepower);
        this.acceleration = acceleration;
        this.setSuspension(suspension);
        this.durability = durability;
    }

    public void tuneCar(int index , String addOn){
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

    protected void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    protected void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    /*
    o	“{brand} {model} {yearOfProduction}
o	 {horsepower} m/h in HP, 100 {acceleration} s
o	 {suspension} Suspension force, {durability} Durability”

     */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %s %d",this.brand,this.model,this.yearOfProduction)).append(System.lineSeparator());
        sb.append(String.format("%d m/h in HP, 100 %d s",this.horsepower,this.acceleration)).append(System.lineSeparator());
        sb.append(String.format("%d Suspension force, %d Durability",this.suspension,this.durability))
                .append(System.lineSeparator());
        return sb.toString();
    }
}
