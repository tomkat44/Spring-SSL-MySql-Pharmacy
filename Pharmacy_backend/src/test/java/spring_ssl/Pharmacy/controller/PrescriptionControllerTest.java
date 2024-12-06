package spring_ssl.Pharmacy.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import spring_ssl.Pharmacy.domain.Prescription;
import spring_ssl.Pharmacy.domain.PrescriptionExecution;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class PrescriptionControllerTest {

    @Test
    public void findPrescriptionById() {
        Prescription prescription;
        prescription = when().get("http://localhost:8080/prescription/getSingle/52")
                .then()
                .statusCode(200)
                .extract().as(Prescription.class);

        Assertions.assertEquals(52, prescription.getId());
        Assertions.assertEquals(2, prescription.getQuantityPrescriptions().size());
        Assertions.assertEquals(2, prescription.getPrescriptionExecution());


    }
}
