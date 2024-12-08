package spring_ssl.Pharmacy.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_ssl.Pharmacy.domain.Doctor;
import spring_ssl.Pharmacy.service.DoctorService;

import java.util.List;
import java.util.Optional;

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
    public Optional<Doctor> findSingleDoctorById(int doctorId) {
        return doctorRepository.findById(doctorId);
    }

    @Override
    public Doctor getSingleDoctorById(int doctorId) {
        return doctorRepository.getSingleById(doctorId);
    }

    @Override
    public Doctor getSingleDoctorByAmka(String doctorAmka) {
        return doctorRepository.getSingleByAmka(doctorAmka);
    }

    @Override
    public  void deleteSingleDoctorByAmka(String doctorAmka) {
         doctorRepository.deleteSingleByAmka(doctorAmka);
    }

    @Override
    public void deleteSingleDoctorByEntity(Doctor doctor) {
        doctorRepository.delete(doctor);
    }
}
