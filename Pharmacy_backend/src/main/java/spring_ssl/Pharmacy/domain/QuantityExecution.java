package spring_ssl.Pharmacy.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.*;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = QuantityExecution.class)
@Entity
@Table(name="quantity_executions")
public class QuantityExecution {

    @Id
    @Column(name="Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="quantity_execution_pieces", length = 10)
    private Integer quantityExecutionPieces;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "drug_id")
//    private Drug drug;

    //, cascade = CascadeType.ALL
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "prescription_execution_id")
    private PrescriptionExecution prescriptionExecution; //Αυτό το όνομα πρέπει να είναι το ίδιο στο mappedBy = "prescription"

    public QuantityExecution(){

    }

    public QuantityExecution(Drug drug, PrescriptionExecution prescriptionExecution, int quantityExecution) {
        //this.drug = drug;
        this.prescriptionExecution = prescriptionExecution;
        this.quantityExecutionPieces = quantityExecution;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantityExecutionPieces() {
        return quantityExecutionPieces;
    }

    public void setQuantityExecutionPieces(Integer quantityExecutionPieces) {
        this.quantityExecutionPieces = quantityExecutionPieces;
    }

//    public Drug getDrug() {
//        return drug;
//    }
//
//    public void setDrug(Drug drug) {
//        this.drug = drug;
//    }

    public PrescriptionExecution getPrescriptionExecution() {
        return prescriptionExecution;
    }

    public void setPrescriptionExecution(PrescriptionExecution prescriptionExecution) {
        this.prescriptionExecution = prescriptionExecution;
    }
}
