package spring_ssl.Pharmacy.service;

import spring_ssl.Pharmacy.domain.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {

    public Doctor insertDoctor(Doctor doctor);

    public List<Doctor> getAllDoctor();

    public Optional<Doctor> findSingleDoctorById(int doctorId);

    public Doctor getSingleDoctorById(int doctorId);

    public Doctor getSingleDoctorByAmka(String doctorAmka);

    public void deleteSingleDoctorByAmka(String doctorAmka);

    public void deleteSingleDoctorByEntity(Doctor doctor);
}
