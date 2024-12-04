package spring_ssl.Pharmacy.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_ssl.Pharmacy.domain.Prescription;
import spring_ssl.Pharmacy.service.PrescriptionService;

import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionImplementation implements PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;


    @Override
    public Prescription insertPrescription(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    @Override
    public Optional<Prescription> findPrescriptionById(int prescriptionId) {
        return prescriptionRepository.findById(prescriptionId);
    }
}