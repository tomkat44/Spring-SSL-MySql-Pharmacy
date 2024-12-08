package spring_ssl.Pharmacy.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Doctor.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="doctor")
public class Doctor {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "AMKA", length = 200, nullable = false)
    private String amka;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Column(name = "password", length = 50)
    private String password;


//    @OneToMany(mappedBy="doctor_prescription", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
//    private Set<Prescription> doctorPrescriptions = new HashSet<Prescription>();


    public Doctor(){

    }

    public Doctor(String amka, String email, String password) {
        this.amka = amka;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAmka() {
        return amka;
    }

    public void setAmka(String amka) {
        this.amka = amka;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Set<Prescription> getPrescriptions() {
//        return doctorPrescriptions;
//    }
//
//    public void setPrescriptions(Set<Prescription> prescriptions) {
//        this.doctorPrescriptions = prescriptions;
//    }
}
