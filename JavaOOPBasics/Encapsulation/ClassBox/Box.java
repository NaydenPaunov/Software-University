package Encapsulation.ClassBox;

/**
 * Created by na4oy on 2.3.2017 г..
 */
public class Box {
    private Double lenght ;
    private Double width ;
    private Double height;

    public Box(Double lenght, Double width, Double height) {
        this.lenght = lenght;
        this.width = width;
        this.height = height;
    }

    public Double getLenght() {
        return this.lenght;
    }

    public void setLenght(Double lenght) {
        this.lenght = lenght;
    }

    public Double getWidth() {
        return this.width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return this.height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getSurfaceArea (){
        //2lw + 2lh + 2wh
        Double surfaceArea  = 2*this.getLenght()*this.getWidth() + 2*this.getLenght()*this.getHeight() + 2*this.getWidth()*this.getHeight();
        return surfaceArea;
    }

    public Double getLateralSurfaceArea (){
       // 2lh + 2wh
         Double area = 2*this.getLenght()*this.getHeight() + 2*this.getWidth()*this.getHeight();
         return area;
    }

    public Double getVolume (){
        //lwh
        Double area = this.getHeight()*this.getWidth()*this.getLenght();
        return area;
    }
}
