package DefiningClassesExr.SpeedRace;

/**
 * Created by na4oy on 27.2.2017 г..
 */
public class Car {
    private String carModel ;
    private Double fuelAmount;
    private Double fuelCost ;
    private Integer distanceTraveled;

    public Car (String model , Double fuelAmount , Double fuelCost){
        this.setCarModel(model);
        this.setFuelAmount(fuelAmount);
        this.setFuelCost(fuelCost);
        this.setDistanceTraveled(0);
    }

    public String getCarModel() {
        return carModel;
    }

    private void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Double getFuelAmount() {
        return fuelAmount;
    }

    private void setFuelAmount(Double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public Double getFuelCost() {
        return fuelCost;
    }

    private void setFuelCost(Double fuelCost) {
        this.fuelCost = fuelCost;
    }

    public Integer getDistanceTraveled() {
        return distanceTraveled;
    }

    private void setDistanceTraveled(Integer distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public void  moveCar(Integer wantedDistance ){
        double fuelNeeded = wantedDistance * this.getFuelCost();
        if (fuelNeeded <= this.getFuelAmount()) {
            this.setFuelAmount(this.getFuelAmount() - fuelNeeded);
            this.setDistanceTraveled(this.getDistanceTraveled() + wantedDistance);
        }else{
            System.out.println("Insufficient fuel for the drive");
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.getCarModel(),this.getFuelAmount(),this.getDistanceTraveled());
    }
}
