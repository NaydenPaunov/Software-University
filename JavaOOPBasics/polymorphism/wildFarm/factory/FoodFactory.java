package polymorphism.wildFarm.factory;

import polymorphism.wildFarm.Food.Food;
import polymorphism.wildFarm.Food.Meat;
import polymorphism.wildFarm.Food.Vegetable;

/**
 * Created by na4oy on 10.3.2017 г..
 */
public class FoodFactory {

    public Food getFood(String tokens[]){
        String type = tokens[0];
        int quantity =Integer.parseInt(tokens[1]);

        switch (type.toLowerCase()){
            case "vegetable":
                return new Vegetable(quantity);
            case "meat":
                return new Meat(quantity);
            default:
                return null;
        }
    }
}
