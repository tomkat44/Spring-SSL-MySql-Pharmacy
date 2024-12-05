package spring_ssl.Pharmacy.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_ssl.Pharmacy.domain.Drug;
import spring_ssl.Pharmacy.service.DrugService;

import java.util.List;

@Service
public class DrugImplementation implements DrugService {

    @Autowired
    private DrugRepository drugRepository;

    @Override
    public Drug addDrug(Drug drug){
        return drugRepository.save(drug);
    }

    @Override
    public List<Drug> getAllDrug() {
        return drugRepository.findAll();
    }

    @Override
    public Drug getSingleDrugByName(String name) {return drugRepository.getSingleByName(name);}

    @Override
    public Drug getSingleDrugById(int id) {return drugRepository.getSingleById(id);}

}
