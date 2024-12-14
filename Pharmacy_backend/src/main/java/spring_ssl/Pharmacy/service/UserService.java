package spring_ssl.Pharmacy.service;

import spring_ssl.Pharmacy.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public User insertUser(User user);

    public List<User> getAllUser();

    public Optional<User> findSingleUserById(int userId);

    public User getSingleUserById(int userId);

    public User getSingleUserByAmka(String userAmka);

    public void deleteSingleUserByAmka(String userAmka);
}
