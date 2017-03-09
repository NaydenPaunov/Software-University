package Inheritance.FragileBaseClass;

/**
 * Created by na4oy on 8.3.2017 г..
 */
public class Predator extends Animal {
    private Integer health ;


    public void feed(Food food){
        super.eat(food);
        this.health++;
    }
    public void feedAll(Food[] foods){
        for (Food food : foods) {
            feed(food);
        }
    }

}
