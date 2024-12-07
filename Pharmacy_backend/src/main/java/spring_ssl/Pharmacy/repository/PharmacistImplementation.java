package spring_ssl.Pharmacy.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_ssl.Pharmacy.domain.Pharmacist;
import spring_ssl.Pharmacy.service.PharmacistService;

import java.util.List;

@Service
public class PharmacistImplementation implements PharmacistService {

    @Autowired
    private PharmacistRepository pharmacistRepository;

    @Override
    public Pharmacist insertPharmacist(Pharmacist pharmacist) {
        return pharmacistRepository.save(pharmacist);
    }

    @Override
    public List<Pharmacist> getAllPharmacist() {
        return pharmacistRepository.findAll();
    }

    @Override
    public Pharmacist getSinglePharmacistByAmka(String pharmacistAmka) {
        return pharmacistRepository.getSingleByAmka(pharmacistAmka);
    }
}
