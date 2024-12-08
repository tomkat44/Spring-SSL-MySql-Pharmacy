package spring_ssl.Pharmacy.controller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PutMapping("/update/{doctorId}")
    public Doctor update(@PathVariable int doctorId, @RequestBody Doctor doctorRequest){

        return doctorService.findSingleDoctorById(doctorId)
                .map(doctor -> {
                    doctor.setAmka(doctorRequest.getAmka());
                    doctor.setEmail(doctorRequest.getEmail());
                    doctor.setPassword(doctorRequest.getPassword());
                    return doctorService.insertDoctor(doctor);
                })
                .orElseGet(() -> {
                    return doctorService.insertDoctor(doctorRequest);
                });

    }

    @GetMapping ("/getAll")
    public List<Doctor> list() {return doctorService.getAllDoctor();}

    @GetMapping("/getSingle/{doctorAmka}")
    public ResponseEntity<Doctor> getSingleDoctor(@PathVariable String doctorAmka){
        return new ResponseEntity<Doctor>(doctorService.getSingleDoctorByAmka(doctorAmka), HttpStatus.OK);
    }

    //Delete works but not remove doctor_id from Prescription
    @DeleteMapping("delete/{doctorAmka}")
    @Transactional //Mandatory to execute Delete
    public void deleteSingleDoctor(@PathVariable String doctorAmka){
        doctorService.deleteSingleDoctorByAmka(doctorAmka);
    }

}
