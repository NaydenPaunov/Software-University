package polymorphism.wildFarm.Animal;

import polymorphism.wildFarm.Food.Food;

import java.text.DecimalFormat;

/**
 * Created by na4oy on 10.3.2017 г..
 */
public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion,String breed) {
        super(animalName, animalType, animalWeight,livingRegion);
        this.setBreed(breed);

    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
        super.setFoodEaten(food.getQuantity());
    }

    private void setBreed(String breed) {
        this.breed = breed;
    }

    private String getBreed() {
        return this.breed;
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %s, %d]",super.getAnimalType(),super.getAnimalName(),
                this.getBreed(),new DecimalFormat("#.################").format(super.getAnimalWeight()),
                this.getLivingRegion(),super.getFoodEaten());
    }
}
