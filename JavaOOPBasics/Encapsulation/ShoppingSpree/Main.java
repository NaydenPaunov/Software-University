package Encapsulation.ShoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by na4oy on 3.3.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> personList = new ArrayList<>();
        List<Product> productList = new ArrayList<>();

        String[] people = reader.readLine().split(";");
        for (int i = 0; i < people.length; i++) {
            String[] personAndMoney = people[i].split("=");
            String personName = personAndMoney[0];
            Double personMoney = Double.parseDouble(personAndMoney[1]);
            Person person = new Person(personName,personMoney);
            personList.add(person);
        }

        String[] products = reader.readLine().split(";");
        for (int i = 0; i < products.length; i++) {
            String[] procuctAndCost = products[i].split("=");
            String productName = procuctAndCost[0];
            Double productCost = Double.parseDouble(procuctAndCost[1]);
            Product product = new Product(productName,productCost);
            productList.add(product);
        }

        String[] getProducts = reader.readLine().split(" ");
        while (!getProducts[0].equals("END")){
            String personName = getProducts[0];
            String productName = getProducts[1];

            for (Person person : personList) {
                if(person.getPersonName().equals(personName)){
                    for (Product product : productList) {
                        if(product.getProductName().equals(productName)){
                            if(person.getMoney() > product.getCost()){
                                System.out.println(person.getPersonName() +  " bought " + product.getProductName());
                                person.boughtProduct(product);
                            }else {
                                System.out.println( person.getPersonName() + " can't afford " + product.getProductName());
                            }
                        }
                    }
                }
            }
        }

        for (Person person : personList) {
            System.out.print(person.getPersonName() + " - " + person.getProductList().toString());

        }


    }
}
//Pesho=11;Gosho=4
//        Bread=10;Milk=2;
//        Pesho Bread
//        Gosho Milk
//        Gosho Milk
//        Pesho Milk
//        END