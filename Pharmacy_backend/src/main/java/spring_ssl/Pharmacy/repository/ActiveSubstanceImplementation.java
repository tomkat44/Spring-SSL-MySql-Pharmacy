package spring_ssl.Pharmacy.repository;

import org.springframework.beans.factory.annotation.Autowired;
import spring_ssl.Pharmacy.domain.ActiveSubstance;
import spring_ssl.Pharmacy.service.ActiveSubstanceService;

import java.util.List;

public class ActivaSubstanceImplementation implements ActiveSubstanceService {

    @Autowired
    private ActiveSubstanceRepository activeSubstanceRepository;


    @Override
    public ActiveSubstance insertActiveSubstance(ActiveSubstance activeSubstance) {
        return activeSubstanceRepository.save(activeSubstance);
    }

    @Override
    public List<ActiveSubstance> getAllActiveSubstance() {
        return activeSubstanceRepository.findAll();
    }

    @Override
    public ActiveSubstance getSingleActiveSubstance(String name) {
        return activeSubstanceRepository.;
    }
}
