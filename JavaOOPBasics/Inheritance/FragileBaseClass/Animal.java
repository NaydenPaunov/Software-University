package Inheritance.FragileBaseClass;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by na4oy on 8.3.2017 г..
 */
public class Animal {
    protected ArrayList<Food> foodEaten ;

    public Animal() {
        this.foodEaten = new ArrayList<>();
    }

    public   final void eat(Food food){
        this.foodEaten.add(food);
    }

    public void eatAll(Food[] foods){
        Collections.addAll(foodEaten,foods);
    }
}
