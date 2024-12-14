package spring_ssl.Pharmacy.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spring_ssl.Pharmacy.config.JwtService;
import spring_ssl.Pharmacy.domain.Doctor;
import spring_ssl.Pharmacy.domain.Pharmacist;
import spring_ssl.Pharmacy.domain.Role;
import spring_ssl.Pharmacy.domain.User;
import spring_ssl.Pharmacy.repository.DoctorRepository;
import spring_ssl.Pharmacy.repository.PatientRepository;
import spring_ssl.Pharmacy.repository.PharmacistRepository;
import spring_ssl.Pharmacy.repository.UserRepository;

import java.util.Objects;

import static spring_ssl.Pharmacy.domain.Role.DOCTOR;


@Service
//@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository,
                                 PasswordEncoder passwordEncoder,
                                 JwtService jwtService,
                                 AuthenticationManager authenticationManager)
    {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }


    public AuthenticationResponse register(RegisterRequest request) {

            var user = new User();
            user.setAmka(request.getAmka());
            user.setEmail(request.getEmail());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            user.setRole(Role.valueOf(request.getRole()));
            User userSaved = userRepository.save(user);

            var jwtToken = jwtService.generateToken(userSaved);

            AuthenticationResponse authenticationResponse = new AuthenticationResponse();
            authenticationResponse.setToken(jwtToken);


        return authenticationResponse;
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        //I call this method for the authentication because if it is not correct an auto Exception appears


        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                        )
        );


        var user = userRepository.findSingleByEmail(request.getEmail())
                .orElseThrow();

            var jwtToken = jwtService.generateToken(user);

            AuthenticationResponse authenticationResponse = new AuthenticationResponse();
            authenticationResponse.setToken(jwtToken);


        return authenticationResponse;
    }
}
