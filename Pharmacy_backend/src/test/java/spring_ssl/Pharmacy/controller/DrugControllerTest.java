package spring_ssl.Pharmacy.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import spring_ssl.Pharmacy.domain.Drug;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class DrugControllerTest {

    @Test
    public void findDrugByName() {
        Drug drug;
        drug = when().get("http://localhost:8080/drug/getSingle/Betadine")
                .then()
                .statusCode(200)
                .extract().as(Drug.class);

        Assertions.assertEquals(1, drug.getId());
        Assertions.assertEquals(1, drug.getActiveSubstance().getId());
    }
}
