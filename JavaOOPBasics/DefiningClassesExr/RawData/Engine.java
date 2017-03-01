package DefiningClassesExr.RawData;

/**
 * Created by na4oy on 28.2.2017 г..
 */
public class Engine {

    private Integer engineSpeed;
    private Integer enginePower;

    public Engine(Integer engineSpeed ,Integer enginePower){
        this.enginePower = enginePower;
        this.engineSpeed = engineSpeed;
    }

    public Integer getEngineSpeed() {
        return this.engineSpeed;
    }

    public Integer getEnginePower() {
        return this.enginePower;
    }
}
