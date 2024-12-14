package spring_ssl.Pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring_ssl.Pharmacy.domain.Doctor;
import spring_ssl.Pharmacy.domain.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findSingleByEmail(String email);

    Optional<User> findSingleByAmka(String amka);

    @Query(value="SELECT u from User u where u.id=:val")
    public User getSingleById(@Param("val") int UserId);

    @Query(value="SELECT u from User u where u.amka=:val")
    public User getSingleByAmka(@Param("val") String userAmka);

    @Query(value="SELECT u from User u where u.email=:val")
    public User getSingleByEmail(@Param("val") String userEmail);

    @Modifying
    @Query(value = "DELETE FROM User u where u.amka=:val")
    public void deleteSingleByAmka(@Param("val") String UserAmka);
}
