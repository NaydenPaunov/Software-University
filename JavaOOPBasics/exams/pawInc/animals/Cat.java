package pawInc.animals;

/**
 * Created by na4oy on 11.3.2017 г..
 */
public class Cat extends Animal{
    private Integer intelligenceCoefficient;

    public Cat(String name, Integer age, String adoptionCenter,Integer intelligenceCoefficient) {
        super(name, age, adoptionCenter);
        this.intelligenceCoefficient = intelligenceCoefficient;
    }
}
