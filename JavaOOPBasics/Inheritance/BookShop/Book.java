package Inheritance.BookShop;

/**
 * Created by na4oy on 8.3.2017 г..
 */
public class Book {
    private String author;
    private String title;
    private Double price;


    public Book(String author, String title, Double price) {
        this.setAuthor(author);
        this.setTitle(title);
        this.setPrice(price);


    }

    public String getAuthor() {
        return this.author;
    }

    public String getTitle() {
        return this.title;
    }

    public Double getPrice() {
        return this.price;
    }

    private void setAuthor(String author) {
        String[] autorNames = author.split("\\s+");
        if(autorNames.length > 1){
            String autorSecondName = autorNames[1].trim();
            if(autorSecondName.charAt(0) == '0' ||
                    autorSecondName.charAt(0) == '1' ||
                    autorSecondName.charAt(0) == '2' ||
                    autorSecondName.charAt(0) == '3' ||
                    autorSecondName.charAt(0) == '4' ||
                    autorSecondName.charAt(0) == '5' ||
                    autorSecondName.charAt(0) == '6' ||
                    autorSecondName.charAt(0) == '7' ||
                    autorSecondName.charAt(0) == '8' ||
                    autorSecondName.charAt(0) == '9' )  {

                throw new IllegalArgumentException("Author not valid!");
            }
        }
        this.author = author;
    }

    private void setTitle(String title) {
        if(title == null || title.length() < 3){
            throw new IllegalArgumentException("Title not valid!");
        }
        this.title = title;
    }

    private void setPrice(Double price) {
        if(price == 0 || price < 0){
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

    @Override
    public String toString() {

        final StringBuilder sb = new StringBuilder();

        sb.append("Type: ").append(this.getClass().getSimpleName())

                .append(System.lineSeparator())

                .append("Title: ").append(this.getTitle())

                .append(System.lineSeparator())

                .append("Author: ").append(this.getAuthor())

                .append(System.lineSeparator())

                .append("Price: ").append(this.getPrice())

                .append(System.lineSeparator());

        return sb.toString();
    }
}

