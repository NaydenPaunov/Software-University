package polymorphism.wildFarm.Food;

/**
 * Created by na4oy on 10.3.2017 г..
 */
public abstract class Food {
    private Integer quantity;

    public Food(Integer quantity) {
        this.quantity = quantity;
    }

    public int getQuantity(){
        return this.quantity;
    }
}
