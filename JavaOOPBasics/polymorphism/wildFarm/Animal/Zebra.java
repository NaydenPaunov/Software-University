package polymorphism.wildFarm.Animal;

import polymorphism.wildFarm.Food.Food;

/**
 * Created by na4oy on 10.3.2017 г..
 */
public class Zebra extends Mammal{
    public Zebra(String animalName, String animalType, Double animalWeight,String livingRegion) {
        super(animalName, animalType, animalWeight,livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

}
