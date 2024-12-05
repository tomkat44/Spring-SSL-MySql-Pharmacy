package spring_ssl.Pharmacy.service;

import spring_ssl.Pharmacy.domain.Drug;

import java.util.List;
import java.util.Optional;


public interface DrugService {

    public Drug addDrug(Drug drug);

    public List<Drug> getAllDrug();

    public Drug getSingleDrugByName(String name);

    public Drug getSingleDrugById(int id);
}
