package Encapsulation.ShoppingSpree;

/**
 * Created by na4oy on 3.3.2017 г..
 */
public class Product {
    private String productName ;
    private Double cost;

    public Product(String productName, Double cost) {
        this.setProductName(productName);
        this.setCost(cost);
    }

    public String getProductName() {
        return this.productName;
    }

    public Double getCost() {
        return this.cost;
    }

    public void setProductName(String productName) {
        if (productName.isEmpty() ){
            throw new IllegalArgumentException("Name cannot be an empty string.");
        }
        this.productName = productName;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
