package polymorphism.wildFarm;

import polymorphism.wildFarm.Animal.Animal;
import polymorphism.wildFarm.Food.Food;
import polymorphism.wildFarm.factory.AnimalFactory;
import polymorphism.wildFarm.factory.FoodFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by na4oy on 10.3.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = "";
        AnimalFactory animalFactory = new AnimalFactory();
        FoodFactory foodFactory = new FoodFactory();
        while (!"End".equals(line = reader.readLine())){
            String[] animalsTokens = line.split("\\s+");
            Animal animal = animalFactory.getAnimal(animalsTokens);
            String[] foodTokens = reader.readLine().split(" ");
            Food food = foodFactory.getFood(foodTokens);
            animal.makeSound();
            try {
                animal.eat(food);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

            System.out.println(animal);
        }
    }
}
