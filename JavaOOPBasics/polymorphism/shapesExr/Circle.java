package polymorphism.shapesExr;

/**
 * Created by na4oy on 10.3.2017 г..
 */
public class Circle extends Shape{
    private Double radius;

    public Circle(Double radius) {
        this.setRadius(radius);
        this.calculatePerimeter();
        this.calculateArea();
    }

    @Override
    public void calculatePerimeter() {
        super.setPerimeter(2*3.14*this.getRadius());
    }

    @Override
    public void calculateArea() {
        super.setArea(3.14*(this.getRadius()*this.getRadius()));
    }

    private void setRadius(Double radius) {
        this.radius = radius;
    }

    protected final Double getRadius() {
        return this.radius;
    }

}
