package spring_ssl.Pharmacy.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DrugTest {

    @Test
    public void addNewDrug(){
        Drug drug = new Drug();
        drug.setDrugName("Depon");
        drug.setDrugPrice(5.11);
        drug.setMedicineCategory(MedicineCategory.ORIGINALS);
        ActiveSubstance as = new ActiveSubstance();
        drug.setActiveSubstance(as);

        assertNotNull(drug.getActiveSubstance());
        assertEquals(5.11, drug.getDrugPrice());

    }
}
