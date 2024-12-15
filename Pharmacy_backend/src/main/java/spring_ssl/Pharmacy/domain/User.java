package spring_ssl.Pharmacy.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = User.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
//@Builder(builderClassName="Builder")
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name="user")
public class User implements UserDetails {

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

    public User(){

    }

    public User(String amka, String email, String password, Role role) {
        this.amka = amka;
        this.email = email;
        this.password = password;
        this.role = role;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == Role.ADMIN){
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_DOCTOR"),
                    new SimpleGrantedAuthority("ROLE_PATIENT"),
                    new SimpleGrantedAuthority("ROLE_PHARMACIST"));
        } else if(this.role == Role.DOCTOR){
            return List.of(new SimpleGrantedAuthority("ROLE_DOCTOR"));
        } else if (this.role == Role.PHARMACIST) {
            return List.of(new SimpleGrantedAuthority("ROLE_PHARMACIST"));
        } else if(this.role == Role.PATIENT){
            return List.of(new SimpleGrantedAuthority("ROLE_PATIENT"));
        } else {
            return null;
        }

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







}
