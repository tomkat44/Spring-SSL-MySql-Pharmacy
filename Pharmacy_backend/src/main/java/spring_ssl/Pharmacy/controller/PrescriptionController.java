package spring_ssl.Pharmacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_ssl.Pharmacy.domain.Drug;
import spring_ssl.Pharmacy.domain.Prescription;
import spring_ssl.Pharmacy.domain.QuantityPrescription;
import spring_ssl.Pharmacy.repository.DrugRepository;
import spring_ssl.Pharmacy.repository.PrescriptionRepository;
import spring_ssl.Pharmacy.repository.QuantityPrescriptionRepository;
import spring_ssl.Pharmacy.service.DrugService;
import spring_ssl.Pharmacy.service.PrescriptionService;
import spring_ssl.Pharmacy.service.QuantityPrescriptionService;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/prescription")
@CrossOrigin //to avoid CORS problem
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;
    private QuantityPrescriptionRepository quantityPrescriptionRepository;
    private QuantityPrescriptionService quantityPrescriptionService;
    private PrescriptionRepository prescriptionRepository;
    private QuantityPrescriptionController quantityPrescriptionController;

    @Autowired
    private DrugService drugService;
    private DrugRepository drugRepository;

    @PostMapping("/createPrescription/{drugId}/{qpNumber}/drug")
    public ResponseEntity<Prescription> createPrescription(@PathVariable(value = "drugId") int drugId,
                                                           @PathVariable(value = "qpNumber") int qpNumber,
                                                           @RequestBody Prescription prescriptionRequest){

        QuantityPrescription qp = quantityPrescriptionController.createQuantityPrescription2(qpNumber, drugService.getDrugById(drugId));
//        QuantityPrescription qp = new QuantityPrescription();
//        quantityPrescriptionRepository.save(qp);

        Prescription _prescription = prescriptionService.insertPrescription(new Prescription(prescriptionRequest.getDoctorAMKA(),
                prescriptionRequest.getDoctorAMKA(), prescriptionRequest.getDiagnosis(), prescriptionRequest.getCreationDate()));

        System.out.println("prescription ID = "+_prescription.getId());
        //QuantityPrescription qp = new QuantityPrescription(qpNumber, drugService.getDrugById(drugId));

        //QuantityPrescription qp = new QuantityPrescription(qpNumber, drugService.getDrugById(drugId), _prescription);



        //QuantityPrescription qp = quantityPrescriptionService.insertQuantityPrescription(new QuantityPrescription(qpNumber, drugService.getDrugById(drugId)));
        //System.out.println("qpNumber= "+qp.getQuantityPrescription()+"qpId= "+qp.getId()+"drudId= "+ drugService.getDrugById(drugId).getDrugName());
        _prescription.addQuantityPrescription(qp);


        prescriptionRepository.save(_prescription);

        return new ResponseEntity<>(_prescription, HttpStatus.CREATED);
    }



    @GetMapping("/{prescriptionId}")
    public ResponseEntity<Optional<Prescription>> getSinglePrescription(@PathVariable int prescriptionId){
        return new ResponseEntity<Optional<Prescription>>(prescriptionService.findPrescriptionById(prescriptionId), HttpStatus.OK);
    }
}
