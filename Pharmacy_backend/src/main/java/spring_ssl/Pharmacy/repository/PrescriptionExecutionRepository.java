package spring_ssl.Pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring_ssl.Pharmacy.domain.Prescription;
import spring_ssl.Pharmacy.domain.PrescriptionExecution;

public interface PrescriptionExecutionRepository extends JpaRepository <PrescriptionExecution, Integer> {

    @Query(value="SELECT pe from PrescriptionExecution pe where pe.id=:val")
    public PrescriptionExecution getSingleById(@Param("val") int prescriptionExecutionId);
}
