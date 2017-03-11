package polymorphism.shapesExr;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by na4oy on 10.3.2017 г..
 */
public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(3.0,3.0);
        Shape circle = new Circle(4.2);

        List<Shape> shapesList = new ArrayList<>();
        shapesList.add(rectangle);
        shapesList.add(circle);

        for (Shape shapes : shapesList) {
            System.out.println(shapes.getArea());
            System.out.println(shapes.getPerimeter());
        }

    }
}
