package gameStore.models;


import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    @Size(min = 3 ,max = 100)
    @Pattern(regexp = "([A-Z].*)")
    private String title;

    @Digits(integer = 5,fraction = 2)
    @Column(name = "price")
    private BigDecimal price;

    @Digits(integer = 5,fraction = 1)
    @Column(name = "size")
    private BigDecimal size;

    @Column(name = "trailer")
    @Size(min = 11 , max = 11)
    private String trailer;

    @Column(name = "thumbnail_url")
    @Pattern(regexp = "^(http:\\/\\/|https:\\/\\/)+[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(\\/.*)?$")
    private String thumbnailUrl;

    @Column(name = "description")
    @Size(min = 20)
    private String description;

    @ManyToMany(mappedBy = "products")
    private Set<Order> orders;

    public Game() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        if(price.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Price must be a positive number!");
        }
        this.price = price;
    }

    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        if(size.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Size must be a positive number!");
        }
        this.size = size;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

}
