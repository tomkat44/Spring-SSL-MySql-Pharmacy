package spring_ssl.Pharmacy.service;

import spring_ssl.Pharmacy.domain.Doctor;

import java.util.List;

public interface DoctorService {

    public Doctor insertDoctor(Doctor doctor);

    public List<Doctor> getAllDoctor();

    public Doctor getSingleDoctorByAmka(String doctorId);
}
