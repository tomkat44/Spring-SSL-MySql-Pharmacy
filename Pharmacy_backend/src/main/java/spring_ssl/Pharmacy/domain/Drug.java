package spring_ssl.Pharmacy.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
public class Drug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String drugName;

    private double drugPrice;

    @Enumerated(EnumType.STRING)
    private MedicineCategory medicineCategory;

    //To fetch the active substance in Postman i should write EAGER OR @JsonIgnore to avoid serialization - decetrialization
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "active_substance_id", nullable = false)
    private ActiveSubstance activeSubstance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public double getDrugPrice() {
        return drugPrice;
    }

    public void setDrugPrice(double drugPrice) {
        this.drugPrice = drugPrice;
    }

    public spring_ssl.Pharmacy.domain.MedicineCategory getMedicineCategory() {
        return medicineCategory;
    }

    public void setMedicineCategory(spring_ssl.Pharmacy.domain.MedicineCategory medicineCategory) {
        this.medicineCategory = medicineCategory;
    }

    public ActiveSubstance getActiveSubstance() {
        return activeSubstance;
    }

    public void setActiveSubstance(ActiveSubstance activeSubstance) {
        this.activeSubstance = activeSubstance;
    }
}
