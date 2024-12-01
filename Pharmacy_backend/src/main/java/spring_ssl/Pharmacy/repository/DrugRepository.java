package spring_ssl.Pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_ssl.Pharmacy.domain.Drug;

import java.util.List;

@Repository
public interface DrugRepository extends JpaRepository<Drug, Integer> {
    List<Drug> findActiveSubstanceById(int id);
}
