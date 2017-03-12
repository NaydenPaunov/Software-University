package pawInc.animals;

/**
 * Created by na4oy on 11.3.2017 г..
 */
public class Dog extends Animal{
    private Integer amountOfCommands;

    public Dog(String name, Integer age, String adoptionCenter,Integer amountOfCommands) {
        super(name, age, adoptionCenter);
        this.amountOfCommands = amountOfCommands;
    }
}
