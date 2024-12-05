package spring_ssl.Pharmacy.service;

import spring_ssl.Pharmacy.domain.QuantityPrescription;
import spring_ssl.Pharmacy.repository.QuantityPrescriptionRepository;

import java.util.Optional;

public interface QuantityPrescriptionService {

    public QuantityPrescription insertQuantityPrescription(QuantityPrescription quantityPrescription);

    public Optional<QuantityPrescription> findQuantityPrescriptionById(int quantityPrescriptionId);


}
