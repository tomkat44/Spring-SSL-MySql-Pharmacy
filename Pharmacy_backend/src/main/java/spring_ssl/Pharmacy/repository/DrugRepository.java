package spring_ssl.Pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring_ssl.Pharmacy.domain.Drug;

import java.util.List;

@Repository
public interface DrugRepository extends JpaRepository<Drug, Integer> {
    List<Drug> findActiveSubstanceById(int id);

    @Query(value="SELECT d from Drug d where d.drugName=:val")
    //@Query(value="SELECT d from Drug d inner join ActiveSubstance a on d.active_substance_id=a.id where d.drugName=:val")
    public Drug getSingle(@Param("val") String drugName);


}
