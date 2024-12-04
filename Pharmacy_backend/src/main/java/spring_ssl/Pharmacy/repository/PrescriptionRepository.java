package spring_ssl.Pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring_ssl.Pharmacy.domain.Drug;
import spring_ssl.Pharmacy.domain.Prescription;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> {
    @Query(value="SELECT p from Prescription p where p.id=:val")
    public Prescription getSingleById(@Param("val") int prescriptionId);
}
