package spring_ssl.Pharmacy.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_ssl.Pharmacy.domain.Patient;
import spring_ssl.Pharmacy.service.PatientService;

import java.util.List;

@Service
public class PatientImplementation implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient insertPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getSinglePatientByAmka(String patientAmka) {
        return patientRepository.getSingleByAmka(patientAmka);
    }
}
