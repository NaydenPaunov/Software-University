package polymorphism.shapesExr;

/**
 * Created by na4oy on 10.3.2017 г..
 */
public abstract class  Shape{
    private Double perimeter;
    private Double area;

    protected Shape(){

    }

    protected final Double getPerimeter() {
        return this.perimeter;
    }

    protected void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    protected final Double getArea() {
        return this.area;
    }

    protected void setArea(Double area) {
        this.area = area;
    }

    public abstract void calculatePerimeter();
    public abstract void calculateArea();
}
