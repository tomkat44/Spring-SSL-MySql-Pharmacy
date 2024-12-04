package spring_ssl.Pharmacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_ssl.Pharmacy.domain.Drug;
import spring_ssl.Pharmacy.domain.Prescription;
import spring_ssl.Pharmacy.domain.QuantityPrescription;
import spring_ssl.Pharmacy.repository.DrugRepository;
import spring_ssl.Pharmacy.repository.PrescriptionRepository;
import spring_ssl.Pharmacy.repository.QuantityPrescriptionRepository;
import spring_ssl.Pharmacy.service.DrugService;
import spring_ssl.Pharmacy.service.PrescriptionService;
import spring_ssl.Pharmacy.service.QuantityPrescriptionService;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/prescription")
@CrossOrigin //to avoid CORS problem
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;
    private QuantityPrescriptionRepository quantityPrescriptionRepository;
    private QuantityPrescriptionService quantityPrescriptionService;
    private PrescriptionRepository prescriptionRepository;
    private QuantityPrescriptionController quantityPrescriptionController;

    @Autowired
    private DrugService drugService;
    private DrugRepository drugRepository;

    //@PostMapping("/createPrescription/{drugId}/{qpNumber}/drug")
    @PostMapping("/add")
    public ResponseEntity<Prescription> createPrescription(/*@PathVariable(value = "drugId") int drugId,
                                                           @PathVariable(value = "qpNumber") int qpNumber,*/
                                                           @RequestBody Prescription prescriptionRequest){
        prescriptionService.insertPrescription(prescriptionRequest);
        return new ResponseEntity<>(prescriptionRequest, HttpStatus.CREATED);
    }


    @GetMapping("/{prescriptionId}")
    public ResponseEntity<Prescription> getSinglePrescription(@PathVariable int prescriptionId){
        return new ResponseEntity<Prescription>(prescriptionService.getPrescriptionById(prescriptionId), HttpStatus.OK);
    }
}
