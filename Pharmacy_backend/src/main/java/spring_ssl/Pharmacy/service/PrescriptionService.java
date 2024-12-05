package spring_ssl.Pharmacy.service;

import spring_ssl.Pharmacy.domain.Prescription;

import java.util.Optional;

public interface PrescriptionService {

    public Prescription insertPrescription(Prescription prescription);

    public Optional<Prescription> findPrescriptionById(int prescriptionId);

    public Prescription getPrescriptionById(int prescriptionId);

}
