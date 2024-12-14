package spring_ssl.Pharmacy.controller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_ssl.Pharmacy.domain.Doctor;
import spring_ssl.Pharmacy.domain.User;
import spring_ssl.Pharmacy.exception.UserNotFoundException;
import spring_ssl.Pharmacy.service.PrescriptionExecutionService;
import spring_ssl.Pharmacy.service.PrescriptionService;
import spring_ssl.Pharmacy.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/user")
@CrossOrigin //to avoid CORS problem
public class UserController {

    @Autowired
    private UserService userService;
    private PrescriptionService prescriptionService;
    private PrescriptionExecutionService prescriptionExecutionService;

    @PostMapping("/add")
    public ResponseEntity<User> add(@RequestBody User user){
        userService.insertUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/update/{userId}")
    public User update(@PathVariable int userId, @RequestBody User userRequest){

        return userService.findSingleUserById(userId)
                .map(user -> {
                    user.setAmka(userRequest.getAmka());
                    user.setEmail(userRequest.getEmail());
                    user.setPassword(userRequest.getPassword());
                    return userService.insertUser(user);
                })
                .orElseGet(() -> {
                    return userService.insertUser(userRequest);
                });

    }

    //RESTfull getAll
    @GetMapping("/getAll")
    CollectionModel<EntityModel<User>> listAll(){

        List<EntityModel<User>> users = userService.getAllUser().stream()
                .map(user -> EntityModel.of(user,
                        linkTo(methodOn(UserController.class).getSingleUserById(user.getId())).withSelfRel(),
                        linkTo(methodOn(UserController.class).listAll()).withRel("users")))
                .collect(Collectors.toList());

        return CollectionModel.of(users, linkTo(methodOn(UserController.class).listAll()).withSelfRel());
    }

    //https://spring.io/guides/tutorials/rest#_spring_hateoas
    //RESTfull API the other are RPC methods
    @GetMapping("/getSingleById/{userId}")
    EntityModel<User> getSingleUserById(@PathVariable int userId){
        User user = userService.findSingleUserById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

        return EntityModel.of(user, //
                linkTo(methodOn(UserController.class).getSingleUserById(userId)).withSelfRel(),
                linkTo(methodOn(UserController.class).listAll()).withRel("users"));
    }

    @GetMapping("/getSingleByAmka/{userAmka}")
    public ResponseEntity<User> getSingleUserByAmka(@PathVariable String userAmka){
        return new ResponseEntity<User>(userService.getSingleUserByAmka(userAmka), HttpStatus.OK);
    }

    //Delete works but not remove doctor_id from Prescription
    @DeleteMapping("delete/{userAmka}")
    @Transactional //Mandatory to execute Delete
    public void deleteSingleUserByAmka(@PathVariable String userAmka){
        userService.deleteSingleUserByAmka(userAmka);
    }

}
