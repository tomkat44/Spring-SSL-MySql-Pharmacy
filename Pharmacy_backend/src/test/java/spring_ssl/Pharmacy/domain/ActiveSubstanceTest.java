package spring_ssl.Pharmacy.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ActiveSubstanceTest {

    @Test
    public void addActiveSubstance() {
        ActiveSubstance as1 = new ActiveSubstance();
        as1.setSubstanceName("Povidoni");
        as1.setExpectedQuantity(22);
        Assertions.assertEquals(22, as1.getExpectedQuantity());


    }
    @Test
    public void checkActiveSubstanceEquals() {
        ActiveSubstance as1 = new ActiveSubstance();
        as1.setSubstanceName("Povidoni");
        as1.setExpectedQuantity(22);
        ActiveSubstance as2 = new ActiveSubstance();
        as2.setSubstanceName("horonali");
        as2.setExpectedQuantity(1);
        boolean check = as1.equals(as2);
        Assertions.assertFalse(check);
    }
}
