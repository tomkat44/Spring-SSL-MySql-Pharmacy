package spring_ssl.Pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring_ssl.Pharmacy.domain.Doctor;
import spring_ssl.Pharmacy.domain.Drug;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    @Query(value="SELECT d from Doctor d where d.amka=:val")
    public Doctor getSingleByAmka(@Param("val") String DoctorAmka);
}
