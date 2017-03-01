package DefiningClassesExr.RawData;

/**
 * Created by na4oy on 28.2.2017 г..
 */
public class Tire {

    private Double tirePressure;
    private Integer tireAge;

    public Tire(Double tirePressure , Integer tireAge){
        this.tireAge = tireAge;
        this.tirePressure = tirePressure;
    }

    public Double getTirePressure() {
        return this.tirePressure;
    }

    public Integer getTireAge() {
        return this.tireAge;
    }

}
