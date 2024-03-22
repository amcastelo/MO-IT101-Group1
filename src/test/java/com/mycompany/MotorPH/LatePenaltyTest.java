package com.mycompany.MotorPH;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LatePenaltyTest {
    public static double actualLateDeduction;

    @Test
    public void testCalculate() {
        double lateTime = 540; // Minutes
        double lateThreshold = 480; // Minutes
        double expectedDeduction = 150; // Expected deduction amount for late time

        double totalLateDeduction = calculateLateDeduction(lateTime, lateThreshold);
        
        actualLateDeduction = totalLateDeduction;
        
        assertEquals(expectedDeduction, totalLateDeduction, 0.001); // Adjust delta as needed
    }
    
    @ParameterizedTest
    @CsvSource({
        "540, 480, 150", // Case where lateTime exceeds lateThreshold
        "480, 480, 0",   // Case where lateTime equals lateThreshold
        "300, 480, 0"    // Case where lateTime is less than lateThreshold
    })
    public void testCalculateParameterized(double lateTime, double lateThreshold, double expectedDeduction) {
        double totalLateDeduction = calculateLateDeduction(lateTime, lateThreshold);
        
        actualLateDeduction = totalLateDeduction;
        
        assertEquals(expectedDeduction, totalLateDeduction, 0.001); // Adjust delta as needed
    }
    
    private double calculateLateDeduction(double lateTime, double lateThreshold) {
        double totalLateDeduction = 0;
        
        if (lateTime >= lateThreshold) {
            // Calculate the per-minute equivalent of the hourly rate
            double hourlyRate = 150;
            double perMinuteRate = hourlyRate / 60.0;

            // Calculate the deduction amount based on late time
            double deduction = perMinuteRate * (lateTime - lateThreshold);

            // Ensure deduction is non-negative
            totalLateDeduction += Math.max(0, deduction);
        }
        
        return totalLateDeduction;
    }
}
