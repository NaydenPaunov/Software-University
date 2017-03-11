package polymorphism.shapesExr;

/**
 * Created by na4oy on 10.3.2017 г..
 */
public class Rectangle extends Shape{
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.setHeight(height);
        this.setWidth(width);
        this.calculateArea();
        this.calculatePerimeter();
    }

    @Override
    public void calculatePerimeter() {
       super.setPerimeter(this.getWidth()*2 + this.getHeight()*2);
    }

    @Override
    public void calculateArea() {
       super.setArea(this.getHeight()*this.getWidth());
    }

    private void setHeight(Double height) {
        this.height = height;
    }

    private void setWidth(Double width) {
        this.width = width;
    }

    private final Double getHeight() {
        return this.height;
    }

    private final Double getWidth() {
        return this.width;
    }
}
