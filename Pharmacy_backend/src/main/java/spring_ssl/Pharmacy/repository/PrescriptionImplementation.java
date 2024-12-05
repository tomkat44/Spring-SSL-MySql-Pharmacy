package spring_ssl.Pharmacy.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_ssl.Pharmacy.domain.Prescription;
import spring_ssl.Pharmacy.service.PrescriptionService;

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
    public Prescription insertPrescriptionQuery(Prescription prescription) {
        return null;
    }

    @Override
    public Optional<Prescription> findPrescriptionById(int prescriptionId) {
        return prescriptionRepository.findById(prescriptionId);
    }

    @Override
    public Prescription getPrescriptionById(int prescriptionId){
        return prescriptionRepository.getSingleById(prescriptionId);
    }
}
