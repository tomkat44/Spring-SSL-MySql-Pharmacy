package spring_ssl.Pharmacy.controller;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_ssl.Pharmacy.domain.ActiveSubstance;
import spring_ssl.Pharmacy.service.ActiveSubstanceService;


import java.util.List;

@RestController
@RequestMapping("/activesubstance")
@CrossOrigin //to avoid CORS problem
public class ActiveSubstanceController {

    @Autowired
    private ActiveSubstanceService activeSubstanceService;

    @PostMapping ("/add")
    public String add(@RequestBody ActiveSubstance activeSubstance){
        activeSubstanceService.insertActiveSubstance(activeSubstance);
        return "New active Substance in inserted";
    }

    @GetMapping ("/getAll")
    public List<ActiveSubstance> list() {return activeSubstanceService.getAllActiveSubstance();}

    @GetMapping("/{substanceName}")
    public ResponseEntity<ActiveSubstance> getSingleActiveSubstance(@PathVariable String substanceName){
        return new ResponseEntity<ActiveSubstance>(activeSubstanceService.singleActiveSubstance(substanceName), HttpStatus.OK);
    }
}
