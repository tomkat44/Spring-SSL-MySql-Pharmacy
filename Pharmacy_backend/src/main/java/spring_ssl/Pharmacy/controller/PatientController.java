package spring_ssl.Pharmacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_ssl.Pharmacy.domain.Doctor;
import spring_ssl.Pharmacy.domain.Patient;
import spring_ssl.Pharmacy.service.PatientService;

import java.util.List;

@RestController
@RequestMapping("/patient")
@CrossOrigin //to avoid CORS problem
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/add")
    public ResponseEntity<Patient> add(@RequestBody Patient patient){
        patientService.insertPatient(patient);
        return new ResponseEntity<>(patient, HttpStatus.CREATED);
    }

    @GetMapping ("/getAll")
    public List<Patient> list() {return patientService.getAllPatient();}

    @GetMapping("/getSingle/{patientAmka}")
    public ResponseEntity<Patient> getSinglePatient(@PathVariable String patientAmka){
        return new ResponseEntity<Patient>(patientService.getSinglePatientByAmka(patientAmka), HttpStatus.OK);
    }
}
