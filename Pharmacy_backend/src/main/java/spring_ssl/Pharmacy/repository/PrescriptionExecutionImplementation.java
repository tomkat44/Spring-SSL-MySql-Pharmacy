package spring_ssl.Pharmacy.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_ssl.Pharmacy.domain.PrescriptionExecution;
import spring_ssl.Pharmacy.service.PrescriptionExecutionService;

@Service
public class PrescriptionExecutionImplementation implements PrescriptionExecutionService {

    @Autowired
    private PrescriptionExecutionRepository prescriptionExecutionRepository;

    @Override
    public PrescriptionExecution insertPrescriptionExecution(PrescriptionExecution prescriptionExecution) {
        return prescriptionExecutionRepository.save(prescriptionExecution);
    }

    @Override
    public PrescriptionExecution getPrescriptionExecutionById(int prescriptionExecution) {
        return prescriptionExecutionRepository.getSingleById(prescriptionExecution);
    }
}
