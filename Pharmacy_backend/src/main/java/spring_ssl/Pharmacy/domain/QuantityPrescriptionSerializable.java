package spring_ssl.Pharmacy.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class QuantityPrescriptionSerializable implements Serializable {

    private int id;

    //@Column(name="PRESCRIPTION_ID")
    private int prescription_id;

    //@Column(name="DRUG_ID")
    private int drug_id;
}
