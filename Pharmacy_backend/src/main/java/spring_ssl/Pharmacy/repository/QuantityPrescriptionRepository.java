package spring_ssl.Pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_ssl.Pharmacy.domain.QuantityPrescription;

@Repository
public interface QuantityPrescriptionRepository extends JpaRepository<QuantityPrescription, Integer> {

}
