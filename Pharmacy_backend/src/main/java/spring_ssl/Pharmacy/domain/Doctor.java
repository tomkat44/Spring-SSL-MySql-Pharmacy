package spring_ssl.Pharmacy.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Doctor.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
//@Builder(builderClassName="Builder")
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name="doctor")
public class Doctor implements UserDetails {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "AMKA", length = 200, nullable = false)
    private String amka;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Column(name = "password")
    private String password;



    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;


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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return List.of(new SimpleGrantedAuthority(role.name()));
//    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == Role.ADMIN){
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_DOCTOR"));
        }
        return List.of(new SimpleGrantedAuthority("ROLE_DOCTOR"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return id == doctor.id && Objects.equals(amka, doctor.amka) && Objects.equals(email, doctor.email) && Objects.equals(password, doctor.password) && role == doctor.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amka, email, password, role);
    }
}
