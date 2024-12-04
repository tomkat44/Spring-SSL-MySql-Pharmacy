package spring_ssl.Pharmacy.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name="quantity_prescriptions")
public class QuantityPrescription {

    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="quantity_prescription", length = 10, nullable = false)
    private int quantityPrescription;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "drug_id", nullable = false)
    //@JsonIgnore
    private Drug drug;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "prescription_id")
    //@JsonIgnore
    private Prescription prescription; //Αυτό το όνομα πρέπει να είναι το ίδιο στο mappedBy = "prescription"


    public QuantityPrescription() {
    }

    public QuantityPrescription(Integer quantityPrescription, Drug drug, Prescription prescription) {
        this.quantityPrescription = quantityPrescription;
        this.drug = drug;
        this.prescription = prescription;
    }

    public QuantityPrescription(Integer quantityPrescription, Drug drug) {
        this.quantityPrescription = quantityPrescription;
        this.drug = drug;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantityPrescription() {
        return quantityPrescription;
    }

    public void setQuantityPrescription(Integer quantityPrescription) {
        this.quantityPrescription = quantityPrescription;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

}
