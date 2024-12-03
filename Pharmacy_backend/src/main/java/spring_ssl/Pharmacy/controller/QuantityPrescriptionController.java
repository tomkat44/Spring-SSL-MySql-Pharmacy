package spring_ssl.Pharmacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring_ssl.Pharmacy.service.QuantityPrescriptionService;

@Service
public class QuantityPrescriptionController {

    @Autowired
    private QuantityPrescriptionService quantityPrescriptionService;
}
