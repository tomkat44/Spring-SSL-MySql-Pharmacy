package spring_ssl.Pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_ssl.Pharmacy.domain.QuantityExecution;

import java.util.Objects;

@Repository
public interface QuantityExecutionRepository extends JpaRepository<QuantityExecution, Integer> {


}
