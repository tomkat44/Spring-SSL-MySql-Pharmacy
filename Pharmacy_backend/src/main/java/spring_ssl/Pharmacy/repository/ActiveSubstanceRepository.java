package spring_ssl.Pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring_ssl.Pharmacy.domain.ActiveSubstance;

@Repository
public interface ActiveSubstanceRepository extends JpaRepository <ActiveSubstance, Integer> {

    @Query(value="SELECT a from ActiveSubstance a where a.id=:val")
    public ActiveSubstance getSingleById(@Param("val") int substanceId);

    @Query(value="SELECT a from ActiveSubstance a where a.substanceName=:val")
    public ActiveSubstance getSingleByName(@Param("val") String substanceName);
}
