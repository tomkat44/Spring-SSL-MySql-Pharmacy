package spring_ssl.Pharmacy.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="prescription")
public class Prescription {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="doctor_AMKA", length=15, nullable=false)
    private String doctorAMKA;

    @Column(name="patient_AMKA", length=15, nullable=false)
    private String patientAMKA;

    @Column(name="diagnosis", length=4000, nullable=false)
    private String diagnosis;

    @Column(name="creation_Date", length=40)
    private String creationDate = LocalDate.now().toString();

    /*Σχέση πολλά προς 1 το οποίο πρέπει να είναι mappedBy = "prescription" όπου
     * αυτό είναι το ίδιο όνομα με τον πίνακα @ManyToOne στο QuantityPrescription*/
    @OneToMany(mappedBy = "prescription", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<QuantityPrescription> quantityPrescriptions = new HashSet<QuantityPrescription>();

    public Prescription() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDoctorAMKA() {
        return doctorAMKA;
    }

    public void setDoctorAMKA(String doctorAMKA) {
        this.doctorAMKA = doctorAMKA;
    }

    public String getPatientAMKA() {
        return patientAMKA;
    }

    public void setPatientAMKA(String patientAMKA) {
        this.patientAMKA = patientAMKA;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Set<QuantityPrescription> getQuantityPrescriptions() {
        return quantityPrescriptions;
    }

    public void setQuantityPrescriptions(Set<QuantityPrescription> quantityPrescriptions) {
        this.quantityPrescriptions = quantityPrescriptions;
    }
}
