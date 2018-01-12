package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "prescribed_medicaments")
public class PrescribedMedicaments {

    @Id
    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(name = "patient_prescribed_medicaments",
            joinColumns =
            @JoinColumn(name = "medicament_name", referencedColumnName = "name"),
            inverseJoinColumns =
            @JoinColumn(name = "patient_id" , referencedColumnName = "id"))
    private Set<Patient> consumedBy;

    public PrescribedMedicaments() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Patient> getConsumedBy() {
        return consumedBy;
    }

    public void setConsumedBy(Set<Patient> consumedBy) {
        this.consumedBy = consumedBy;
    }
}
