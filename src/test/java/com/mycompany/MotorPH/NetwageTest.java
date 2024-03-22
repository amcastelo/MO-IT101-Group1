package com.mycompany.MotorPH;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NetwageTest {

    @Test
    public void testCalculate() {
        
        SSSTest sss = new SSSTest();
        PhilhealthTest philhealth = new PhilhealthTest();
        PagibigTest pagibig = new PagibigTest();
        GrosswageTest grosswage = new GrosswageTest();
        WithholdingTaxTest tax = new WithholdingTaxTest();
        LatePenaltyTest late = new LatePenaltyTest();

        // Run the test methods for each calculation
        sss.testCalculate();
        philhealth.testCalculate();
        pagibig.testCalculate();
        tax.testCalculate();
        late.testCalculate();
        grosswage.testCalculate();       
        

        // Define the expected output
        double expectedGrossWage = 24000;
        double expectedSSS = 1125;
        double expectedPhilHealth = 375.00;
        double expectedPagibig = 100.00;
        double expectedLate = 150;
        double expectedTax = 483.6;
        double expectedTaxableIncome = 23250;
        double expectedNetWage = 22766.4;

        // Parse the values from the printed output
        double actualGrossWage = GrosswageTest.gross;
        double actualSSS =  SSSTest.actualSSS;
        double actualPhilHealth = PhilhealthTest.actualPhilhealthDeduction;
        double actualPagibig = PagibigTest.actualPagibigDeduction;
        double actualLate = LatePenaltyTest.actualLateDeduction;
        double actualTax = WithholdingTaxTest.tax;
        double actualTaxableIncome = WithholdingTaxTest.taxableIncome;
        double actualNetWage = WithholdingTaxTest.AfterTax;

        // Assert each value received
        assertEquals(expectedGrossWage, actualGrossWage);
        assertEquals(expectedSSS, actualSSS);
        assertEquals(expectedPhilHealth, actualPhilHealth);
        assertEquals(expectedPagibig, actualPagibig);
        assertEquals(expectedLate, actualLate);
        assertEquals(expectedTax, actualTax);
        assertEquals(expectedTaxableIncome, actualTaxableIncome);
        assertEquals(expectedNetWage, actualNetWage);
    }
}
