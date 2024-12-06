package spring_ssl.Pharmacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_ssl.Pharmacy.domain.Prescription;
import spring_ssl.Pharmacy.domain.PrescriptionExecution;
import spring_ssl.Pharmacy.service.PrescriptionExecutionService;

@RestController
@RequestMapping("/prescriptionExecution")
@CrossOrigin //to avoid CORS problem
public class PrescriptionExecutionController {

    @Autowired
    PrescriptionExecutionService prescriptionExecutionService;

    @GetMapping("/getSingle/{prescriptionExecutionId}")
    public ResponseEntity<PrescriptionExecution> getSinglePrescription(@PathVariable int prescriptionExecutionId){
        return new ResponseEntity<PrescriptionExecution>(prescriptionExecutionService.getPrescriptionExecutionById(prescriptionExecutionId), HttpStatus.OK);
    }
}
