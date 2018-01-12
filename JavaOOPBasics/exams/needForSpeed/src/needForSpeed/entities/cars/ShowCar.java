package needForSpeed.entities.cars;

public class ShowCar extends Car {

    private int stars;

    protected ShowCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.stars = 0;
    }

    public void tuneCar(int index , String addOn) {
        this.stars += index;
        super.tuneCar(index,addOn);
    }

    @Override
    public String toString() {
        return String.format("%s%d *", super.toString(), this.stars);
    }
}
