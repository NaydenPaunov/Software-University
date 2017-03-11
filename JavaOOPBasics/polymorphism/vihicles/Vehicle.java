package polymorphism.vihicles;

/**
 * Created by na4oy on 10.3.2017 г..
 */
public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;

    protected Vehicle(double fuelQuantity, double fuelConsumption) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
    }

    private void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    private void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void refuel(double amount){
        double currentFuel = getFuelQuantity();
        setFuelQuantity(currentFuel + amount);
    }

    public boolean drive(double distance){
        if(distance * fuelConsumption <= fuelQuantity){
            fuelQuantity -= distance * fuelConsumption;
            return true;
        }

        return false;
    }
}
