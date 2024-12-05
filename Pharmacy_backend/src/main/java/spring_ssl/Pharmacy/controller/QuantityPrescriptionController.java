package spring_ssl.Pharmacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import spring_ssl.Pharmacy.domain.Drug;
import spring_ssl.Pharmacy.domain.Prescription;
import spring_ssl.Pharmacy.domain.QuantityPrescription;
import spring_ssl.Pharmacy.service.DrugService;
import spring_ssl.Pharmacy.service.PrescriptionService;
import spring_ssl.Pharmacy.service.QuantityPrescriptionService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/createPrescription")
@CrossOrigin //to avoid CORS problem
public class QuantityPrescriptionController {

    @Autowired
    private QuantityPrescriptionService quantityPrescriptionService;
    @Autowired
    private DrugService drugService;
    @Autowired
    private PrescriptionService prescriptionService;

    @PostMapping("/add")
    public QuantityPrescription createQuantityPrescription(@RequestBody QuantityPrescription quantityPrescriptionRequest) {
        return quantityPrescriptionService.insertQuantityPrescription(quantityPrescriptionRequest);
    }

    @PostMapping("/add/{qpNumber}/{drugId}/{prescriptionId}")
    public ResponseEntity<QuantityPrescription> createDrug(@PathVariable(value = "qpNumber") int qpNumber,
                                           @PathVariable(value = "drugId") int drugId,
                                           @PathVariable(value = "prescriptionId") int prescriptionId,
                                           @RequestBody QuantityPrescription quantityPrescriptionRequest) {
        quantityPrescriptionRequest.setQuantityPrescription(qpNumber);
        quantityPrescriptionRequest.setDrug(drugService.getSingleDrugById(drugId));
        quantityPrescriptionRequest.setPrescription(prescriptionService.getPrescriptionById(prescriptionId));
        quantityPrescriptionService.insertQuantityPrescription(quantityPrescriptionRequest);

        return new ResponseEntity<>(quantityPrescriptionRequest, HttpStatus.CREATED);
    }

    @PostMapping("/create")
    @Transactional
    public ResponseEntity<QuantityPrescription> createPrescription(@RequestBody QuantityPrescription quantityPrescriptionRequest) {
        quantityPrescriptionService.insertQuantityPrescription(quantityPrescriptionRequest);
        return new ResponseEntity<>(quantityPrescriptionRequest, HttpStatus.CREATED);
    }

}