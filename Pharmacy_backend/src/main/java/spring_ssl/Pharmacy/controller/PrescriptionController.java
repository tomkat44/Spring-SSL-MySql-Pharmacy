package spring_ssl.Pharmacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_ssl.Pharmacy.domain.Prescription;
import spring_ssl.Pharmacy.service.PrescriptionService;

import java.util.Optional;

@RestController
@RequestMapping("/prescription")
@CrossOrigin //to avoid CORS problem
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @GetMapping("/{prescriptionId}")
    public ResponseEntity<Optional<Prescription>> getSinglePrescription(@PathVariable int prescriptionId){
        return new ResponseEntity<Optional<Prescription>>(prescriptionService.findPrescriptionById(prescriptionId), HttpStatus.OK);
    }
}
