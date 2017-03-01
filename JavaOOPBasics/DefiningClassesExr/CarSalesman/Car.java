package DefiningClassesExr.CarSalesman;

/**
 * Created by na4oy on 28.2.2017 г..
 */
public class Car {
    private String model;
    private String  engine;
    private Integer weight = null;// optional
    private String color = null ; // oprional

    public Car(String model , String  engine){
        this.model = model;
        this.engine = engine;
    }

    public Car(String model ,String engine , Integer weight){
        this(model,engine);
        this.weight = weight;
    }

    public Car(String model ,String engine , String color){
        this(model,engine);
        this.color = color;
    }

    public Car(String model ,String engine , Integer weight , String color){
        this(model,engine,color);
        this.weight = weight;
    }

    public String getModel() {
        return this.model;
    }

    public String getEngine() {
        return this.engine;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public String getColor() {
        return this.color;
    }
}
