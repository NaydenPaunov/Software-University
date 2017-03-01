package DefiningClassesExr.CarSalesman;

/**
 * Created by na4oy on 28.2.2017 г..
 */
public class Engine {
    private String engineModel;
    private Integer enginePower;
    private Integer displacement = null; // is optional
    private String efficiency = null; //  is optional


    public Engine(String engineModel, Integer enginePower){
        this.engineModel = engineModel;
        this.enginePower = enginePower;
    }
    public Engine(String engineModel, Integer enginePower,Integer displacement){
       this(engineModel,enginePower);
       this.displacement = displacement;
    }
    public Engine(String engineModel, Integer enginePower,String efficiency){
        this(engineModel,enginePower);
        this.efficiency = efficiency;
    }

    public Engine(String engineModel, Integer enginePower,Integer displacement , String  efficiency){
        this(engineModel,enginePower,displacement);
        this.efficiency = efficiency;
    }

    public String getEngineModel() {
        return this.engineModel;
    }

    public Integer getEnginePower() {
        return this.enginePower;
    }

    public Integer getDisplacement() {
        return this.displacement;
    }

    public String getEfficiency() {
        return this.efficiency;
    }
}
