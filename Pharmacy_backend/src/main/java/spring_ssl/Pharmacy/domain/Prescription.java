package spring_ssl.Pharmacy.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import spring_ssl.Pharmacy.repository.PrescriptionExecutionRepository;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

//In the following line the scope used here and to the Prescription Execution to separete the @id between two classes.
//The problem appears in the @Test
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Prescription.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

//    @OneToOne(mappedBy = "prescription", cascade = CascadeType.ALL)
//    private PrescriptionExecution prescriptionExecution;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "prescription_execution_id")
    private PrescriptionExecution prescriptionExecution;

    /*Σχέση πολλά προς 1 το οποίο πρέπει να είναι mappedBy = "prescription" όπου
     * αυτό είναι το ίδιο όνομα με τον πίνακα @ManyToOne στο QuantityPrescription*/
    @OneToMany(mappedBy = "prescription", cascade = CascadeType.ALL)
    private Set<QuantityPrescription> quantityPrescriptions = new HashSet<QuantityPrescription>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor_prescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient_prescription;

    public Prescription() {
    }

    public Prescription(String doctorAMKA, String patientAMKA, String diagnosis, QuantityPrescription quantityPrescription) {
        this.doctorAMKA = doctorAMKA;
        this.patientAMKA = patientAMKA;
        this.diagnosis = diagnosis;
        this.creationDate = LocalDate.now().toString();
        this.quantityPrescriptions = (Set<QuantityPrescription>) quantityPrescription;
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

    public PrescriptionExecution getPrescriptionExecution() {
        return prescriptionExecution;
    }

    public void setPrescriptionExecution(PrescriptionExecution prescriptionExecution) {
        this.prescriptionExecution = prescriptionExecution;
    }

    public Set<QuantityPrescription> getQuantityPrescriptions() {
        return quantityPrescriptions;
    }

    public void setQuantityPrescriptions(Set<QuantityPrescription> quantityPrescriptions) {
        this.quantityPrescriptions = quantityPrescriptions;
    }

    public void addQuantityPrescription(QuantityPrescription qp){
        this.quantityPrescriptions.add(qp);
    }

    public Doctor getDoctor_prescription() {
        return doctor_prescription;
    }

    public void setDoctor_prescription(Doctor doctor_prescription) {
        this.doctor_prescription = doctor_prescription;
    }

    public Patient getPatient_prescription() {
        return patient_prescription;
    }

    public void setPatient_prescription(Patient patient_prescription) {
        this.patient_prescription = patient_prescription;
    }
}
