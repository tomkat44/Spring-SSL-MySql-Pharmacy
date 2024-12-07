package spring_ssl.Pharmacy.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_ssl.Pharmacy.domain.Doctor;
import spring_ssl.Pharmacy.service.DoctorService;

import java.util.List;

@Service
public class DoctorImplementation implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor insertDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> getAllDoctor() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getSingleDoctorByAmka(String doctorAmka) {
        return doctorRepository.getSingleByAmka(doctorAmka);
    }
}
