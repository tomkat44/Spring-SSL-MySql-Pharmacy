package spring_ssl.Pharmacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_ssl.Pharmacy.domain.Prescription;
import spring_ssl.Pharmacy.domain.PrescriptionExecution;
import spring_ssl.Pharmacy.domain.QuantityExecution;
import spring_ssl.Pharmacy.domain.QuantityPrescription;
import spring_ssl.Pharmacy.service.PrescriptionExecutionService;
import spring_ssl.Pharmacy.service.QuantityExecutionService;

@RestController
@RequestMapping("/prescriptionExecution")
@CrossOrigin //to avoid CORS problem
public class PrescriptionExecutionController {

    @Autowired
    private final PrescriptionExecutionService prescriptionExecutionService;
    private final QuantityExecutionService quantityExecutionService;

    public PrescriptionExecutionController(PrescriptionExecutionService prescriptionExecutionService, QuantityExecutionService quantityExecutionService){
        this.prescriptionExecutionService = prescriptionExecutionService;
        this.quantityExecutionService = quantityExecutionService;
    }

    @GetMapping("/getSingle/{prescriptionExecutionId}")
    public ResponseEntity<PrescriptionExecution> getSinglePrescription(@PathVariable int prescriptionExecutionId){
        return new ResponseEntity<PrescriptionExecution>(prescriptionExecutionService.getPrescriptionExecutionById(prescriptionExecutionId), HttpStatus.OK);
    }

    @PutMapping("/execute/{id}")
    public ResponseEntity<PrescriptionExecution> executePrescription(@RequestBody PrescriptionExecution prescriptionExecutionRequest, @PathVariable int id) {


        PrescriptionExecution savedPrescriptionExecution = prescriptionExecutionService.insertPrescriptionExecution(prescriptionExecutionRequest);
        System.out.println("ID = "+savedPrescriptionExecution.getId());
        System.out.println("Pharmacist = "+savedPrescriptionExecution.getPharmacistAFM());

        // Step 2: Save QuantityPrescriptions linked to the Prescription
        for (QuantityExecution quantityData : prescriptionExecutionRequest.getQuantityExecutions()) {
            QuantityExecution quantityExecution = new QuantityExecution();
            quantityExecution.setPrescriptionExecution(savedPrescriptionExecution);
            quantityExecution.setQuantityExecutionPieces(quantityData.getQuantityExecutionPieces());
            //quantityExecution.setDrug(quantityData.getPrescriptionExecution().getPrescription().);
            quantityExecutionService.insertQuantityExecution(quantityExecution);


        }


        return new ResponseEntity<>(prescriptionExecutionRequest, HttpStatus.CREATED);
    }

}
