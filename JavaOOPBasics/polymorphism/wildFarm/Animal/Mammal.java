package polymorphism.wildFarm.Animal;

import polymorphism.wildFarm.Food.Food;

import java.text.DecimalFormat;

/**
 * Created by na4oy on 10.3.2017 г..
 */
public abstract class Mammal extends Animal{
    private String livingRegion;


    public Mammal(String animalName, String animalType, Double animalWeight,String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    protected String getLivingRegion() {
        return this.livingRegion;
    }

    private void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    @Override
    public void eat(Food food) {
        if ("Vegetable".equals(food.getClass().getSimpleName())) {
            super.setFoodEaten(food.getQuantity());
        } else {
            throw new IllegalArgumentException(String.format("%ss are not eating that type of food!", super.getAnimalType()));
        }
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %d]",super.getAnimalType(),super.getAnimalName(),
                new DecimalFormat("#.################").format(super.getAnimalWeight()),
                this.getLivingRegion(),super.getFoodEaten());
    }
}
