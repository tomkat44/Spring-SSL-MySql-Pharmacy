package spring_ssl.Pharmacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_ssl.Pharmacy.domain.Patient;
import spring_ssl.Pharmacy.domain.Pharmacist;
import spring_ssl.Pharmacy.service.PharmacistService;

import java.util.List;

@RestController
@RequestMapping("/pharmacist")
@CrossOrigin //to avoid CORS problem
public class PharmacistController {

    @Autowired
    private PharmacistService pharmacistService;

    @PostMapping("/add")
    public ResponseEntity<Pharmacist> add(@RequestBody Pharmacist pharmacist){
        pharmacistService.insertPharmacist(pharmacist);
        return new ResponseEntity<>(pharmacist, HttpStatus.CREATED);
    }

    @GetMapping ("/getAll")
    public List<Pharmacist> list() {return pharmacistService.getAllPharmacist();}

    @GetMapping("/getSingle/{pharmacistAmka}")
    public ResponseEntity<Pharmacist> getSinglePharmacist(@PathVariable String pharmacistAmka){
        return new ResponseEntity<Pharmacist>(pharmacistService.getSinglePharmacistByAmka(pharmacistAmka), HttpStatus.OK);
    }
}
