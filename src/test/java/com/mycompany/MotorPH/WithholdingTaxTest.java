package com.mycompany.MotorPH;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class WithholdingTaxTest {
    public static double AfterTax, tax, taxableIncome;

    // Separate method to calculate withholding tax
    private static double calculateTax(double taxableIncome) {
        double tax = 0;
        // Calculation logic for withholding tax
        if (taxableIncome <= 20832) {
            tax = 0;
        } else if (taxableIncome > 20832 && taxableIncome <= 33333) {
            tax = (taxableIncome - 20832) * 0.20;
        } else if (taxableIncome > 33333 && taxableIncome <= 66667) {
            tax = 2500 + (taxableIncome - 33333) * 0.25;
        } else if (taxableIncome > 66667 && taxableIncome <= 166667) {
            tax = 10833 + (taxableIncome - 66667) * 0.30;
        } else if (taxableIncome > 166667 && taxableIncome <= 666667) {
            tax = 40833.33 + (taxableIncome - 166667) * 0.32;
        } else {
            tax = 200833.33 + (taxableIncome - 666667) * 0.35;
        }
        return tax;
    }

    @Test
    public void testCalculate() {
        // Test calculation for a specific taxable income
        taxableIncome = 23250.00;
        double expectedTax = 483.6;
        tax = calculateTax(taxableIncome);
        AfterTax = taxableIncome - tax;
        assertEquals(expectedTax, tax, .001); // Verify calculated tax
    }

    @ParameterizedTest
    @CsvSource({
            "10000.0, 0.0", // Test case for taxable income below the first tax bracket
            "20832.0, 0.0", // Test case for taxable income at the boundary of the first tax bracket
            "25000.0, 833.6", // Test case for taxable income between the first and second tax brackets
            "33333.0, 2500.2", // Test case for taxable income at the boundary of the second tax bracket
            // Add more test cases as needed
    })
    public void testCalculateWithDifferentIncome(double income, double expectedTax) {
        tax = calculateTax(income);
        assertEquals(expectedTax, tax, .001); // Verify calculated tax
    }
}
