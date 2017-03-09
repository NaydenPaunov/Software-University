package Encapsulation.ClassBoxDataValidation;

/**
 * Created by na4oy on 2.3.2017 г..
 */
public class Box {
    private Double lenght ;
    private Double width ;
    private Double height;

    public Box(Double lenght, Double width, Double height) {
       this.setHeight(height);
       this.setLenght(lenght);
       this.setWidth(width);
    }
    public Double getHeight() {
        return this.height;
    }

    public Double getLenght() {
        return this.lenght;
    }

    public Double getWidth() {
        return this.width;
    }

    public void setLenght(Double lenght) {
        if(lenght < 0 ){
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.lenght = lenght;
    }

    public void setWidth(Double width) {
        if(width < 0 ){
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    public void setHeight(Double height) {
        if(height < 0 ){
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
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
