package spring_ssl.Pharmacy.service;

import spring_ssl.Pharmacy.domain.Patient;
import spring_ssl.Pharmacy.domain.Pharmacist;

import java.util.List;

public interface PharmacistService {

    public Pharmacist insertPharmacist(Pharmacist pharmacist);

    public List<Pharmacist> getAllPharmacist();

    public Pharmacist getSinglePharmacistByAmka(String pharmacistAmka);
}
