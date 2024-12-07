package spring_ssl.Pharmacy.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_ssl.Pharmacy.domain.ActiveSubstance;
import spring_ssl.Pharmacy.service.ActiveSubstanceService;

import java.util.List;
import java.util.Optional;

@Service
public class ActiveSubstanceImplementation implements ActiveSubstanceService {

    @Autowired
    private ActiveSubstanceRepository activeSubstanceRepository;

    @Override
    public ActiveSubstance insertActiveSubstance(ActiveSubstance activeSubstance) {return activeSubstanceRepository.save(activeSubstance);}

    @Override
    public Optional<ActiveSubstance> findSubstanceById(int substanceId) {return activeSubstanceRepository.findById(substanceId);}

    @Override
    public List<ActiveSubstance> getAllActiveSubstance() {
        return activeSubstanceRepository.findAll();
    }

    @Override
    public ActiveSubstance singleActiveSubstance(String name) {return activeSubstanceRepository.getSingleByName(name);}

    @Override
    public ActiveSubstance getActiveSubstanceById(int substanceId) {
        return activeSubstanceRepository.getSingleById(substanceId);
    }

}
