package spring_ssl.Pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_ssl.Pharmacy.domain.QuantityPrescription;

public interface QuantityPrescriptionRepository extends JpaRepository<QuantityPrescription, Integer> {
}
