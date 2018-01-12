package books.entities;

public class ReduceBookDTO {
    private String title;
    private int editionType;
    private int ageRestriction;
    private Double price;

    public ReduceBookDTO(String title, int editionType, int ageRestriction, Double price) {
        this.title = title;
        this.editionType = editionType;
        this.ageRestriction = ageRestriction;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEditionType() {
        return editionType;
    }

    public void setEditionType(int editionType) {
        this.editionType = editionType;
    }

    public int getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(int ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
