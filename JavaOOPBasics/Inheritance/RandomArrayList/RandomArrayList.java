package Inheritance.RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by na4oy on 8.3.2017 г..
 */
public class RandomArrayList extends ArrayList {
    private Random rnd ;

    public RandomArrayList(){
        this.rnd = new Random();
    }


    public Object getRandomElement(){
        Integer index = rnd.nextInt(super.size());
        Object element = super.get(index);
        super.set(index,super.get(super.size() - 1));
        super.remove(super.size() - 1);

        return element;
    }
}
