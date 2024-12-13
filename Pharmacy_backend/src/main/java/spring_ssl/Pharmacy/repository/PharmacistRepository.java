package spring_ssl.Pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring_ssl.Pharmacy.domain.Doctor;
import spring_ssl.Pharmacy.domain.Patient;
import spring_ssl.Pharmacy.domain.Pharmacist;

import java.util.Optional;

@Repository
public interface PharmacistRepository extends JpaRepository<Pharmacist, Integer> {

    @Query(value="SELECT ph from Pharmacist ph where ph.amka=:val")
    public Pharmacist getSingleByAmka(@Param("val") String PharmacistAmka);

    Optional<Pharmacist> findSingleByEmail(String email);
}
