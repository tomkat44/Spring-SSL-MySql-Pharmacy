package spring_ssl.Pharmacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import spring_ssl.Pharmacy.domain.Drug;
import spring_ssl.Pharmacy.domain.Prescription;
import spring_ssl.Pharmacy.domain.QuantityPrescription;
import spring_ssl.Pharmacy.service.QuantityPrescriptionService;

@RestController
@CrossOrigin //to avoid CORS problem
public class QuantityPrescriptionController {

    @Autowired
    private QuantityPrescriptionService quantityPrescriptionService;

    @PostMapping
    public QuantityPrescription createQuantityPrescription(@RequestBody QuantityPrescription quantityPrescription) {
        return quantityPrescriptionService.insertQuantityPrescription(quantityPrescription);
    }


    public QuantityPrescription createQuantityPrescription2(int qpNumber, Drug drug) {

        System.out.println("qpNumber= "+qpNumber+"drudId= "+ drug.getDrugName());

        QuantityPrescription qp = new QuantityPrescription();
        qp.setQuantityPrescription(qpNumber);
        //qp.setPrescription(prescription);
        qp.setDrug(drug);
        System.out.println("qpNumber= "+qp.getQuantityPrescription()+"qpId= "+qp.getId()+"drudId= "+ drug.getDrugName());
        quantityPrescriptionService.insertQuantityPrescription(qp);
        return qp;
    }

}