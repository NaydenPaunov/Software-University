package polymorphism.vihicles;

/**
 * Created by na4oy on 10.3.2017 г..
 */
public class Truck extends Vehicle {
    private static final double addedConsumption = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + addedConsumption);
    }

    @Override
    public void refuel(double amount){
        super.refuel(amount*0.95);
    }

}
