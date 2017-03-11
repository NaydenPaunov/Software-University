package polymorphism.vihicles;

import javax.xml.crypto.dom.DOMCryptoContext;

/**
 * Created by na4oy on 10.3.2017 г..
 */
public class Car extends Vehicle{
    private final static double addedConsumption = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + addedConsumption);
    }
}