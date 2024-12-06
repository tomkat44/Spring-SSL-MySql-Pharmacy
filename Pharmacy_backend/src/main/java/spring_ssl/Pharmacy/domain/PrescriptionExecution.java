package spring_ssl.Pharmacy.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import java.time.LocalDate;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = PrescriptionExecution.class)
@Entity
@Table(name="prescription_execution")
public class PrescriptionExecution {

    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="pharmacist_AFM", length=15)
    private String pharmacistAFM;

    @Column(name="execution_date", length=40, nullable=false)
    private String executionDate;// = SystemDate.now();

    @Column(name="summary_cost", length=15)
    private Double summaryCost;

    @Enumerated(EnumType.STRING)
    @Column(name="execution_flag", length=15)
    private executionPrescriptionFlag executionFlag;

//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
//    @JoinColumn(name = "pharmacist_id")
//    private Pharmacist pharmacist;

//    //Σύνδεση με το QuantityExecution
//    @OneToMany(mappedBy = "prescription_execution", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Set<QuantityExecution> quantityExecutions = new HashSet<QuantityExecution>();


    /*Το θέλω για να μπορώ να πάρω τα στοιχεία της συνταγής μεσα από την εκτέλεσή της*/
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "prescription_id")
    private Prescription prescription;

    public PrescriptionExecution(){
        this.executionDate = LocalDate.now().toString();
        this.executionFlag = executionPrescriptionFlag.PENDING;
    }

    public PrescriptionExecution(String pharmacistAFM) {
        //this.pharmacistAFM = pharmacistAFM;
        this.executionDate = LocalDate.now().toString();
        this.executionFlag = executionPrescriptionFlag.PENDING;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPharmacistAFM() {
        return pharmacistAFM;
    }

    public void setPharmacistAFM(String pharmacistAFM) {
        this.pharmacistAFM = pharmacistAFM;
    }

    public String getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(String executionDate) {
        this.executionDate = executionDate;
    }

    public Double getSummaryCost() {
        return summaryCost;
    }

    public void setSummaryCost(Double summaryCost) {
        this.summaryCost = summaryCost;
    }

    public executionPrescriptionFlag getExecutionFlag() {
        return executionFlag;
    }

    public void setExecutionFlag(executionPrescriptionFlag executionFlag) {
        this.executionFlag = executionFlag;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }
}
