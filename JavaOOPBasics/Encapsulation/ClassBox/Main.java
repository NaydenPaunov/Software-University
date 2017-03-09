package Encapsulation.ClassBox;

import javax.xml.crypto.dom.DOMCryptoContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Created by na4oy on 2.3.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Double lenght = Double.parseDouble(reader.readLine());
        Double  width = Double.parseDouble(reader.readLine());
        Double height = Double.parseDouble(reader.readLine());

        Box box = new Box(lenght,width,height);


        System.out.printf("Surface Area - %.2f%n",box.getSurfaceArea());
        System.out.printf("Lateral Surface Area - %.2f%n" ,box.getLateralSurfaceArea());
        System.out.printf("Volume - %.2f" ,box.getVolume());

    }
}
