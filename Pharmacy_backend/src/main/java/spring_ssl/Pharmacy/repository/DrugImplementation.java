package spring_ssl.Pharmacy.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_ssl.Pharmacy.domain.Drug;
import spring_ssl.Pharmacy.service.DrugService;

import java.util.List;
import java.util.Optional;

@Service
public class DrugImplementation implements DrugService {

    @Autowired
    private DrugRepository drugRepository;

    @Autowired
    private ActiveSubstanceRepository activeSubstanceRepository;

    @Override
    public Drug insertDrug(Drug drug){
        return drugRepository.save(drug);
    }

    @Override
    public List<Drug> getAllDrug() {
        return drugRepository.findAll();
    }

    @Override
    public Drug singleDrug(String name) {
//        Drug drug = drugRepository.getSingle(name);
//        System.out.println("Drug Name = "+ drug.getDrugName());
//        System.out.println("as not in drug = "+ drug.getActiveSubstance().getSubstanceName());
//        ActiveSubstance as = activeSubstanceRepository.getById(drug.getActiveSubstance().getId());
//        System.out.println("Active Substance name = "+as.getSubstanceName());
//        drug.setActiveSubstance(as);
//        System.out.println("as in drug = "+ drug.getActiveSubstance().getSubstanceName());
//        return drug;
        return drugRepository.getSingle(name);
    }

    @Override
    public Optional<Drug> getDrugById(int id) {
        return drugRepository.findById(id);
    }


}
