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
import spring_ssl.Pharmacy.service.PrescriptionService;
import spring_ssl.Pharmacy.service.QuantityExecutionService;
import spring_ssl.Pharmacy.service.QuantityPrescriptionService;

@RestController
@RequestMapping("/prescriptionExecution")
@CrossOrigin //to avoid CORS problem
public class PrescriptionExecutionController {

    @Autowired
    private final PrescriptionExecutionService prescriptionExecutionService;
    private final QuantityExecutionService quantityExecutionService;
    private final PrescriptionService prescriptionService;

    public PrescriptionExecutionController(PrescriptionExecutionService prescriptionExecutionService,
                                           QuantityExecutionService quantityExecutionService,
                                           PrescriptionService prescriptionService){
        this.prescriptionExecutionService = prescriptionExecutionService;
        this.quantityExecutionService = quantityExecutionService;
        this.prescriptionService = prescriptionService;
    }

    @GetMapping("/getSingle/{prescriptionExecutionId}")
    public ResponseEntity<PrescriptionExecution> getSinglePrescription(@PathVariable int prescriptionExecutionId){
        return new ResponseEntity<PrescriptionExecution>(prescriptionExecutionService.getPrescriptionExecutionById(prescriptionExecutionId), HttpStatus.OK);
    }

    @PutMapping("/execute")
    public ResponseEntity<PrescriptionExecution> executePrescription(@RequestBody PrescriptionExecution prescriptionExecutionRequest) {


        PrescriptionExecution savedPrescriptionExecution = prescriptionExecutionService.insertPrescriptionExecution(prescriptionExecutionRequest);
        System.out.println("ID = "+savedPrescriptionExecution.getId());
        System.out.println("Pharmacist = "+savedPrescriptionExecution.getPharmacistAFM());

        Prescription prescription = new Prescription();
                prescription = prescriptionService.getPrescriptionByIdOfPrescriptionExecution(savedPrescriptionExecution);
        System.out.println("ID = "+prescription.getId());
        System.out.println("PreseciptionId = "+prescription.getId());
        System.out.println("QiantityPrescription size = "+prescription.getQuantityPrescriptions().size());

        // Step 2: Save QuantityPrescriptions linked to the Prescription
        for (QuantityExecution quantityData : prescriptionExecutionRequest.getQuantityExecutions()) {
            QuantityExecution quantityExecution = new QuantityExecution();
            quantityExecution.setPrescriptionExecution(savedPrescriptionExecution);
            quantityExecution.setQuantityExecutionPieces(quantityData.getQuantityExecutionPieces());


            for(QuantityPrescription qp : prescription.getQuantityPrescriptions()){
                quantityExecution.setDrug(qp.getDrug());
            }

            quantityExecutionService.insertQuantityExecution(quantityExecution);


        }


        return new ResponseEntity<>(prescriptionExecutionRequest, HttpStatus.CREATED);
    }

}
