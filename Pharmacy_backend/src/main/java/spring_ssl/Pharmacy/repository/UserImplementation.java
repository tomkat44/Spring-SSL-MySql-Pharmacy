package spring_ssl.Pharmacy.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_ssl.Pharmacy.domain.User;
import spring_ssl.Pharmacy.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User insertUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findSingleUserById(int userId) {
        return userRepository.findById(userId);
    }

    @Override
    public User getSingleUserById(int userId) {
        return userRepository.getSingleById(userId);
    }

    @Override
    public User getSingleUserByAmka(String userAmka) {
        return userRepository.getSingleByAmka(userAmka);
    }

    @Override
    public void deleteSingleUserByAmka(String userAmka) {
        userRepository.deleteSingleByAmka(userAmka);
    }
}
