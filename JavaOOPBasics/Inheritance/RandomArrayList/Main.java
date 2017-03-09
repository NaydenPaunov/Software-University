package Inheritance.RandomArrayList;

/**
 * Created by na4oy on 8.3.2017 г..
 */
public class Main {
    public static void main(String[] args) {
        RandomArrayList ral = new RandomArrayList();
        ral.add("asdasd");
        ral.add(1);
        ral.add(2);
        ral.add("gosho");
        ral.add("ivan");

        System.out.println(ral.getRandomElement());
        System.out.println(ral.getRandomElement());
        System.out.println(ral.getRandomElement());
        System.out.println(ral.getRandomElement());

    }

}
