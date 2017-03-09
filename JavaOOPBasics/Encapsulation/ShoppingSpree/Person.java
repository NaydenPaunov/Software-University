package Encapsulation.ShoppingSpree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by na4oy on 3.3.2017 г..
 */
public class Person {
    private String personName ;
    private Double money;
    private List<Product> productList;

    public Person(String personName, Double money) {
        this.setPersonName(personName);
        this.setMoney(money);
    }

    public String getPersonName() {
        return this.personName;
    }

    public Double getMoney() {
        return this.money;
    }

    public List<Product> getProductList() {
        return Collections.unmodifiableList(productList);
    }

    public void setPersonName(String personName) {
        if(personName.isEmpty() ){
            throw new IllegalArgumentException("Name cannot be an empty string.");
        }
        this.personName = personName;
    }

    public void setMoney(Double money) {
        if(money < 0 ){
            throw new IllegalArgumentException("Money cannot be a negative number.");
        }
        this.money = money;
    }

   public void  boughtProduct(Product product){
        this.setMoney(this.getMoney() - product.getCost());
        productList.add(product);
   }

}
