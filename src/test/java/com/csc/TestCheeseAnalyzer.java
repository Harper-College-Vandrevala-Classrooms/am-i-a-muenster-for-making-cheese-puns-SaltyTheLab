package com.csc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestCheeseAnalyzer {

    @Test
    public void threenumberpercent() {
        assertEquals(false, CheeseAnalyzer.percentcheck(
                "BC\tFarmstead\t40.3\t\tmilder than a camembert, stronger than a brie,1,Soft Cheese,Cow,Pasteurized,Bloomy Rind,White Moon,lower fat"));
    }

    @Test
    public void twonumberpercent() {
        assertEquals(true, CheeseAnalyzer.percentcheck(
                "45\tClover and hay taste\tCopper-colored rind\t1\tSemi-soft Cheese\tCow\tRaw Milk\t\tRÃ©serve La PÃ©rade\tlower fat\r\n"));
    }

    @Test
    public void miscellanious() {
        assertEquals(true,
                CheeseAnalyzer.percentcheck(
                        "QC\tIndustrial\t39\tHazelnut taste that sharpens with age. Available: mild, medium, strong, extra-strong 1 year, 2 years and 3 years\t\t1\tFirm Cheese\tCow\tThermised\tNo Rind\tCheddar (Biobio) - Mild, medium and strong\thigher fat\r\n"));
    }
}
