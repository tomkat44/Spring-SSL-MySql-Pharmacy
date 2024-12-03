package spring_ssl.Pharmacy.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

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
    //@JsonIgnore
    private ActiveSubstance activeSubstance;

    @OneToMany(mappedBy = "drug", fetch = FetchType.LAZY)
    private Set<QuantityPrescription> quantityPrescriptions = new HashSet<QuantityPrescription>();



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

    public MedicineCategory getMedicineCategory() {
        return medicineCategory;
    }

    public void setMedicineCategory(MedicineCategory medicineCategory) {
        this.medicineCategory = medicineCategory;
    }

    public ActiveSubstance getActiveSubstance() {
        return activeSubstance;
    }

    public void setActiveSubstance(ActiveSubstance activeSubstance) {
        this.activeSubstance = activeSubstance;
    }
}
