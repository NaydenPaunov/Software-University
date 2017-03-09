package StackOfStrings;

/**
 * Created by na4oy on 8.3.2017 г..
 */
public class Main{
    public static void main(String[] args) {
        StackOfStrings sos = new StackOfStrings();
        sos.push("pesho");
        sos.push("gosho");
        sos.push("ivan");


        System.out.println(sos.pop());
        System.out.println(sos.pop());
        System.out.println(sos.pop());
    }
}
