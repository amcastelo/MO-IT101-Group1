package com.mycompany.MotorPH;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PhilhealthTest {
    
    public static double actualPhilhealthDeduction;

    @Test
    public void testCalculate() {
        double gross = 25000.00; // Example gross wage
        double expected = 375.00; // Expected PhilHealth deduction for gross wage of 1200.00
        
        double philhealthDeduction = calculatePhilhealthDeduction(gross);
        
        assertEquals(expected, philhealthDeduction, 0.001); // Check if expected equals actual with a delta of 0.001
    }
    
    @ParameterizedTest
    @CsvSource({
        "25000.00, 375.00", // Gross wage of 25000.00 should result in a PhilHealth deduction of 375.00
        "80000.00, 1800.00", // Gross wage of 80000.00 should result in a fixed PhilHealth deduction of 1800.00
        "1200.00, 18.00" // Gross wage of 1200.00 should result in a PhilHealth deduction of 18.00
    })
    public void testCalculateParameterized(double gross, double expected) {
        double actualPhilhealthDeduction = calculatePhilhealthDeduction(gross);
        
        assertEquals(expected, actualPhilhealthDeduction, 0.001); // Check if expected equals actual with a delta of 0.001
    }
    
    private double calculatePhilhealthDeduction(double gross) {
        if (gross > 60000) { 
            return 1800;
        } else {
            return (gross * 0.03) / 2;
        }
    }
}
