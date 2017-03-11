package polymorphism.wildFarm.Animal;

import polymorphism.wildFarm.Food.Food;

/**
 * Created by na4oy on 10.3.2017 г..
 */
public class Tiger extends Felime{

    public Tiger(String animalName, String animalType, Double animalWeight,String livingRegion) {
        super(animalName, animalType, animalWeight,livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if("Meat".equals(food.getClass().getSimpleName())){
                super.setFoodEaten(food.getQuantity());
            }else {
                throw new IllegalArgumentException(String.format("%ss are not eating that type of food!", super.getAnimalType()));
            }
    }
}
