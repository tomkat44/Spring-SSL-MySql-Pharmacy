package spring_ssl.Pharmacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_ssl.Pharmacy.domain.ActiveSubstance;
import spring_ssl.Pharmacy.domain.Doctor;
import spring_ssl.Pharmacy.service.DoctorService;

import java.util.List;

@RestController
@RequestMapping("/doctor")
@CrossOrigin //to avoid CORS problem
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/add")
    public ResponseEntity<Doctor> add(@RequestBody Doctor doctor){
        doctorService.insertDoctor(doctor);
        return new ResponseEntity<>(doctor, HttpStatus.CREATED);
    }

    @GetMapping ("/getAll")
    public List<Doctor> list() {return doctorService.getAllDoctor();}

    @GetMapping("/getSingle/{doctorAmka}")
    public ResponseEntity<Doctor> getSingleDoctor(@PathVariable String doctorAmka){
        return new ResponseEntity<Doctor>(doctorService.getSingleDoctorByAmka(doctorAmka), HttpStatus.OK);
    }
}
