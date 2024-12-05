package spring_ssl.Pharmacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_ssl.Pharmacy.domain.Drug;
import spring_ssl.Pharmacy.service.ActiveSubstanceService;
import spring_ssl.Pharmacy.service.DrugService;

import java.util.List;

@RestController
@RequestMapping("/drug")
@CrossOrigin //to avoid CORS problem
public class DrugController {

    @Autowired
    private DrugService drugService;

    @Autowired
    private ActiveSubstanceService activeSubstanceService;


    @PostMapping("/activesubstance/{substanceId}/insertdrug")
    public ResponseEntity<Drug> createDrug(@PathVariable(value = "substanceId") int substanceId,
                                              @RequestBody Drug drugRequest) {
        Drug drug = activeSubstanceService.findSubstanceById(substanceId).map(activeSubstance -> {
            drugRequest.setActiveSubstance(activeSubstance);
            return drugService.addDrug(drugRequest);
        }).orElseThrow();

        return new ResponseEntity<>(drug, HttpStatus.CREATED);
    }


    @GetMapping("/getAll")
    public List<Drug> list() {return drugService.getAllDrug();}

    @GetMapping("/{drugName}")
    public ResponseEntity<Drug> getSingleDrug(@PathVariable String drugName){
        return new ResponseEntity<Drug>(drugService.getSingleDrugByName(drugName), HttpStatus.OK);
    }
}
