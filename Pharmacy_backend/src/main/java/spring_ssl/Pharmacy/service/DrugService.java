package spring_ssl.Pharmacy.service;

import org.springframework.stereotype.Service;
import spring_ssl.Pharmacy.domain.Drug;

import java.util.List;


public interface DrugService {

    public Drug insertDrug(Drug drug);

    public List<Drug> getAllDrug();

    public Drug singleDrug(String name);
}
