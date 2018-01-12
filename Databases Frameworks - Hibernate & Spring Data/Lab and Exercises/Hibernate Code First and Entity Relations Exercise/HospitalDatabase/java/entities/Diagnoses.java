package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "diagnoses")
public class Diagnoses {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "comments")
    private String comments;

    @ManyToMany
    @JoinTable(name = "diagnoses_patients",
            joinColumns =
            @JoinColumn(name = "diagnose_id", referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name = "patient_id" , referencedColumnName = "id"))
    private Set<Patient> patientsDiagnoses;

    public Diagnoses() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Set<Patient> getPatientsDiagnoses() {
        return patientsDiagnoses;
    }

    public void setPatientsDiagnoses(Set<Patient> patientsDiagnoses) {
        this.patientsDiagnoses = patientsDiagnoses;
    }
}
