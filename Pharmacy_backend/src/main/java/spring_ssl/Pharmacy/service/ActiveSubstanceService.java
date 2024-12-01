package spring_ssl.Pharmacy.service;

import spring_ssl.Pharmacy.domain.ActiveSubstance;

import java.util.List;
import java.util.Optional;

public interface ActiveSubstanceService {

    public ActiveSubstance insertActiveSubstance(ActiveSubstance activeSubstance);

    public Optional<ActiveSubstance> findSubstanceById(int substanceId);

    public List<ActiveSubstance> getAllActiveSubstance();

    public ActiveSubstance singleActiveSubstance(String name);


}
