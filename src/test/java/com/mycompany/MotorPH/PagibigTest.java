package com.mycompany.MotorPH;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PagibigTest {
    public static double actualPagibigDeduction = 0;   
    
    @Test
    public void testCalculate() {
        // Original test logic
        double gross = 25000.00; // Example gross wage
        double pagibig;
        double expected = 100.00; // Expected Pagibig deduction for gross wage of 25000.00
        
         if (gross > 1000.00 && gross <= 1500.00) {
            pagibig = gross * 0.03;
        } else {
            pagibig = gross * 0.04;     
        }
         
         // Maximum amount must not exceed 100.
        if (pagibig > 100) {
            pagibig = 100;
        }
         
        actualPagibigDeduction = pagibig;

        assertEquals(expected, actualPagibigDeduction, 0.001);
    }
    
    @ParameterizedTest
    @CsvSource({
        "1500.00, 45.00", // Test for gross wage of 1500.00
        "2500.00, 100.00", // Test for gross wage of 2500.00
        "800.00, 0" // Test for gross wage of 800.00
    })
    public void testCalculateParameterized(double gross, double expected) {
        // Parameterized test logic
        double pagibig;
        if (gross < 1000.00){
            pagibig = 0;
        }
        else if (gross > 1000.00 && gross <= 1500.00) {
            pagibig = gross * 0.03;
        } else {
            pagibig = gross * 0.04;     
        }
         
        // Maximum amount must not exceed 100.
        if (pagibig > 100) {
            pagibig = 100;
        }
         
        actualPagibigDeduction = pagibig;

        assertEquals(expected, actualPagibigDeduction, 0.001);
    }
}
