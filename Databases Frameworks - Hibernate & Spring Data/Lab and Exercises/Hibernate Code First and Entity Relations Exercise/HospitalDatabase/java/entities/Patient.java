package entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "data_of_birth")
    private Date dataOfBirth;

    @Column(name = "picture")
    private String picture;

    @Column(name = "medical_insurance")
    private Boolean medicalInsurance;

    @OneToMany(mappedBy = "patient")
    private Set<Visitors> visitors;

    @ManyToMany(mappedBy = "patientsDiagnoses")
    private Set<Diagnoses> diagnoses;

    @ManyToMany(mappedBy = "consumedBy")
    private Set<PrescribedMedicaments> prescribedMedicaments;


    public Patient() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDataOfBirth() {
        return dataOfBirth;
    }

    public void setDataOfBirth(Date dataOfBirth) {
        this.dataOfBirth = dataOfBirth;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Boolean getMedicalInsurance() {
        return medicalInsurance;
    }

    public void setMedicalInsurance(Boolean medicalInsurance) {
        this.medicalInsurance = medicalInsurance;
    }

    public Set<Visitors> getVisitors() {
        return visitors;
    }

    public void setVisitors(Set<Visitors> visitors) {
        this.visitors = visitors;
    }

    public Set<Diagnoses> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(Set<Diagnoses> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public Set<PrescribedMedicaments> getPrescribedMedicaments() {
        return prescribedMedicaments;
    }

    public void setPrescribedMedicaments(Set<PrescribedMedicaments> prescribedMedicaments) {
        this.prescribedMedicaments = prescribedMedicaments;
    }
}
