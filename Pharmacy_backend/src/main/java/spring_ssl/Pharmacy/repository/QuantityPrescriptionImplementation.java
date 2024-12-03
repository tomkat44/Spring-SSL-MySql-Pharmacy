package spring_ssl.Pharmacy.repository;

import org.springframework.beans.factory.annotation.Autowired;
import spring_ssl.Pharmacy.domain.QuantityPrescription;
import spring_ssl.Pharmacy.service.QuantityPrescriptionService;

import java.util.Optional;

public class QuantityPrescriptionImplementation implements QuantityPrescriptionService {

    @Autowired
    private QuantityPrescriptionRepository quantityPrescriptionRepository;

    @Override
    public QuantityPrescription insertQuantityPrescription(QuantityPrescription quantityPrescription) {
        return quantityPrescriptionRepository.save(quantityPrescription);
    }

    @Override
    public Optional<QuantityPrescription> findQuantityPrescriptionById(int quantityPrescriptionId) {
        return quantityPrescriptionRepository.findById(quantityPrescriptionId);
    }
}
