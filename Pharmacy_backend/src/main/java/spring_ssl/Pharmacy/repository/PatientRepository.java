package spring_ssl.Pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring_ssl.Pharmacy.domain.Doctor;
import spring_ssl.Pharmacy.domain.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    @Query(value="SELECT p from Patient p where p.amka=:val")
    public Patient getSingleByAmka(@Param("val") String PatientAmka);
}
