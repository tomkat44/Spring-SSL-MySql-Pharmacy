package spring_ssl.Pharmacy.domain;

import jakarta.persistence.*;

import java.util.Optional;

@Entity
@Table(name="quantity_prescriptions")
public class QuantityPrescription {

    @Id
    @Column(name="Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="quantity_prescription", length = 10, nullable = false)
    private Integer quantityPrescription;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "drug_id", nullable = false)
    private Drug drug;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "prescription_id")
    private Prescription prescription; //Αυτό το όνομα πρέπει να είναι το ίδιο στο mappedBy = "prescription"


    public QuantityPrescription() {
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
