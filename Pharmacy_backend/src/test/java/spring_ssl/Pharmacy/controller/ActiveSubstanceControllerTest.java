package spring_ssl.Pharmacy.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import spring_ssl.Pharmacy.domain.ActiveSubstance;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;


public class ActiveSubstanceControllerTest {

    @Test
    public void findActiveSubstanceByName() {
        ActiveSubstance activeSubstance;
        activeSubstance = when().get("http://localhost:8080/activesubstance/povidoni")
                .then()
                .statusCode(200)
                .extract().as(ActiveSubstance.class);

        Assertions.assertEquals(1, activeSubstance.getId());
    }

}
