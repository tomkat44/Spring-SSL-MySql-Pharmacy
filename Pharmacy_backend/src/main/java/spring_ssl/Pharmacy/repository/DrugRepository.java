package spring_ssl.Pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring_ssl.Pharmacy.domain.Drug;

import java.util.List;

@Repository
public interface DrugRepository extends JpaRepository<Drug, Integer> {

    @Query(value="SELECT d from Drug d where d.id=:val")
    public Drug getSingleById(@Param("val") int drugId);

    @Query(value="SELECT d from Drug d where d.drugName=:val")
    public Drug getSingleByName(@Param("val") String drugName);

}
