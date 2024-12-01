package spring_ssl.Pharmacy.domain;


import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table(name="active_substance")
public class ActiveSubstance {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="substance_name")
    private String substanceName;

    @Column(name="expected_quantity")
    private String expectedQuantity;




    public ActiveSubstance(){

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubstanceName() {
        return substanceName;
    }

    public void setSubstanceName(String substanceName) {
        this.substanceName = substanceName;
    }

    public String getExpectedQuantity() {
        return expectedQuantity;
    }

    public void setExpectedQuantity(String expectedQuantity) {
        this.expectedQuantity = expectedQuantity;
    }

}
