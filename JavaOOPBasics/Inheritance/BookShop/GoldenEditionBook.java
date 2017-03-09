package Inheritance.BookShop;

/**
 * Created by na4oy on 8.3.2017 г..
 */
public class GoldenEditionBook extends Book{

    public GoldenEditionBook(String author, String title, Double price) {
        super(author, title, price);
    }

    @Override
    public Double getPrice() {
        return super.getPrice() + super.getPrice()*0.3;
    }
}
