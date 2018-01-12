package soft_uni.car_dealer_exercise.domain.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "suppliers")
public class Supplier {
    private Long id;
    private String name;
    private boolean isImporter;
    private Set<Part> partsDelivered;

    public Supplier() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "is_importer")
    public boolean isImporter() {
        return isImporter;
    }

    public void setImporter(boolean importer) {
        isImporter = importer;
    }

    @OneToMany(mappedBy = "supplier")
    public Set<Part> getPartsDelivered() {
        return partsDelivered;
    }

    public void setPartsDelivered(Set<Part> partsDelivered) {
        this.partsDelivered = partsDelivered;
    }
}
