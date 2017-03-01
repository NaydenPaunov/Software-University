package DefiningClassesExr.RawData;

/**
 * Created by na4oy on 28.2.2017 г..
 */
public class Cargo {
    private Integer cargoWeight ;
    private String cargoType;

    public Cargo(Integer cargoWeight , String cargoType){
        this.cargoType = cargoType;
        this.cargoWeight = cargoWeight;
    }

    public Integer getCargoWeight() {
        return this.cargoWeight;
    }

    public String getCargoType() {
        return this.cargoType;
    }
}
