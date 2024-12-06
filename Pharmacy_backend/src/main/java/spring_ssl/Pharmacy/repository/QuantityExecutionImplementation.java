package spring_ssl.Pharmacy.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_ssl.Pharmacy.domain.QuantityExecution;
import spring_ssl.Pharmacy.service.QuantityExecutionService;

@Service
public class QuantityExecutionImplementation implements QuantityExecutionService {

    @Autowired
    private QuantityExecutionRepository quantityExecutionRepository;

    @Override
    public QuantityExecution insertQuantityExecution(QuantityExecution quantityExecution) {
        return quantityExecutionRepository.save(quantityExecution);
    }

    @Override
    public QuantityExecution updateQuantityExecution(QuantityExecution quantityExecution) {
        return quantityExecutionRepository.save(quantityExecution);
    }
}
