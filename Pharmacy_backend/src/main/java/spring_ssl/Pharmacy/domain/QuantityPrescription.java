package spring_ssl.Pharmacy.domain;

import jakarta.persistence.*;

@Entity
@Table(name="quantity_prescriptions")
public class QuantityPrescription {

    @Id
    @Column(name="Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="quantityPrescription", length = 10, nullable = false)
    private Integer quantityPrescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drug_id", nullable = false)
    private Drug drug;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "prescription_id")
    private Prescription prescription; //Αυτό το όνομα πρέπει να είναι το ίδιο στο mappedBy = "prescription"
}
