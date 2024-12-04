package spring_ssl.Pharmacy.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Optional;

@Entity
@Table(name="quantity_prescriptions")
public class QuantityPrescription implements Serializable {

    //@EmbeddedId
    //@Column(name="id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Id
//    private int prescription_id;
//    @Id
//    private int drug_id;

    @Column(name="quantity_prescription", length = 10, nullable = false)
    private int quantityPrescription;

    @ManyToOne(fetch = FetchType.LAZY)
    //@MapsId("drug_id")
    @JoinColumn(name = "drug_id", nullable = false)
    private Drug drug;

    @ManyToOne(fetch = FetchType.LAZY)
    //@MapsId("prescription_id")
    @JoinColumn(name = "prescription_id")
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
