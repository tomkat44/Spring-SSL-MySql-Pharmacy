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

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/prescription")
@CrossOrigin //to avoid CORS problem
public class PrescriptionController {

    @Autowired
    private final PrescriptionService prescriptionService;
    private final QuantityPrescriptionService quantityPrescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService, QuantityPrescriptionService quantityPrescriptionService) {
        this.prescriptionService = prescriptionService;
        this.quantityPrescriptionService = quantityPrescriptionService;
    }

    @PostMapping("/add")
    @Transactional
    public ResponseEntity<Prescription> createPrescription(@RequestBody Prescription prescriptionRequest){

        Prescription prescription = new Prescription();
        prescription.setDoctorAMKA(prescriptionRequest.getDoctorAMKA());
        prescription.setPatientAMKA(prescriptionRequest.getPatientAMKA());
        prescription.setDiagnosis(prescriptionRequest.getDiagnosis());
        prescription.setCreationDate(prescriptionRequest.getCreationDate());
        Prescription savedPrescription = prescriptionService.insertPrescription(prescription);

        // Step 2: Save QuantityPrescriptions linked to the Prescription
        for (QuantityPrescription quantityData : prescriptionRequest.getQuantityPrescriptions()) {
            QuantityPrescription quantityPrescription = new QuantityPrescription();
            quantityPrescription.setPrescription(savedPrescription);
            quantityPrescription.setQuantityPrescription(quantityData.getQuantityPrescription());
            quantityPrescription.setDrug(quantityData.getDrug());
            quantityPrescriptionService.insertQuantityPrescription(quantityPrescription);
        }
        return new ResponseEntity<>(prescriptionRequest, HttpStatus.CREATED);
    }


    @GetMapping("/{prescriptionId}")
    public ResponseEntity<Prescription> getSinglePrescription(@PathVariable int prescriptionId){
        return new ResponseEntity<Prescription>(prescriptionService.getPrescriptionById(prescriptionId), HttpStatus.OK);
    }
}
