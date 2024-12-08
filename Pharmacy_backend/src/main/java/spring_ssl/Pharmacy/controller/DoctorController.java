package spring_ssl.Pharmacy.controller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_ssl.Pharmacy.domain.Doctor;
import spring_ssl.Pharmacy.exception.DoctorNotFoundException;
import spring_ssl.Pharmacy.service.DoctorService;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.stream.Collectors;

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

//    @GetMapping ("/getAll")
//    public List<Doctor> list() {return doctorService.getAllDoctor();}

    //RESTfull getAll
    @GetMapping("/getAll")
    CollectionModel<EntityModel<Doctor>> listAll(){

        List<EntityModel<Doctor>> doctors = doctorService.getAllDoctor().stream()
                .map(doctor -> EntityModel.of(doctor,
                        linkTo(methodOn(DoctorController.class).getSingleDoctorById(doctor.getId())).withSelfRel(),
                        linkTo(methodOn(DoctorController.class).listAll()).withRel("doctors")))
                .collect(Collectors.toList());

        return CollectionModel.of(doctors, linkTo(methodOn(DoctorController.class).listAll()).withSelfRel());
    }

    //https://spring.io/guides/tutorials/rest#_spring_hateoas
    //RESTfull API the other are RPC methods
    @GetMapping("/getSingleById/{doctorId}")
    EntityModel<Doctor> getSingleDoctorById(@PathVariable int doctorId){
        Doctor doctor = doctorService.findSingleDoctorById(doctorId)
                .orElseThrow(() -> new DoctorNotFoundException(doctorId));

        return EntityModel.of(doctor, //
                linkTo(methodOn(DoctorController.class).getSingleDoctorById(doctorId)).withSelfRel(),
                linkTo(methodOn(DoctorController.class).listAll()).withRel("doctors"));
    }

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
