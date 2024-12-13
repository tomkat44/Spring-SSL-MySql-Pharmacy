package spring_ssl.Pharmacy.auth;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spring_ssl.Pharmacy.config.JwtService;
import spring_ssl.Pharmacy.domain.Doctor;
import spring_ssl.Pharmacy.domain.Pharmacist;
import spring_ssl.Pharmacy.domain.Role;
import spring_ssl.Pharmacy.repository.DoctorRepository;
import spring_ssl.Pharmacy.repository.PatientRepository;
import spring_ssl.Pharmacy.repository.PharmacistRepository;

import java.util.Objects;

import static spring_ssl.Pharmacy.domain.Role.DOCTOR;


@Service
//@RequiredArgsConstructor
public class AuthenticationService {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final PharmacistRepository pharmacistRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(DoctorRepository doctorRepository, PatientRepository patientRepository, PharmacistRepository pharmacistRepository,
                                 PasswordEncoder passwordEncoder,
                                 JwtService jwtService,
                                 AuthenticationManager authenticationManager)
    {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.pharmacistRepository = pharmacistRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }


    public AuthenticationResponse register(RegisterRequest request) {

            var doctor = new Doctor();
            doctor.setAmka(request.getAmka());
            doctor.setEmail(request.getEmail());
            doctor.setPassword(passwordEncoder.encode(request.getPassword()));
            doctor.setRole(Role.DOCTOR);
            Doctor doctorSaved = doctorRepository.save(doctor);

            var jwtToken = jwtService.generateToken(doctorSaved);

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


        var doctor = doctorRepository.findSingleByEmail(request.getEmail())
                .orElseThrow();

            var jwtToken = jwtService.generateToken(doctor);

            AuthenticationResponse authenticationResponse = new AuthenticationResponse();
            authenticationResponse.setToken(jwtToken);


        return authenticationResponse;
    }
}
