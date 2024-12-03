package spring_ssl.Pharmacy.service;

import spring_ssl.Pharmacy.domain.Drug;

import java.util.List;
import java.util.Optional;


public interface DrugService {

    public Drug insertDrug(Drug drug);

    public List<Drug> getAllDrug();

    public Drug singleDrug(String name);

    public Optional<Drug> getDrugById(int id);
}
