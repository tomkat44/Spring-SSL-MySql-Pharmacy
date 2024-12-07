package spring_ssl.Pharmacy.service;

import spring_ssl.Pharmacy.domain.Patient;

import java.util.List;

public interface PatientService {

    public Patient insertPatient(Patient patient);

    public List<Patient> getAllPatient();

    public Patient getSinglePatientByAmka(String patientId);
}
