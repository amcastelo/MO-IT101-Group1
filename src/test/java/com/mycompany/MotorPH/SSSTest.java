package com.mycompany.MotorPH;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class SSSTest {
    
    public static double actualSSS;
    
    @Test
    public void testCalculate() {
        double gross = 25000;
        double expected = 1125;
        // Mock SSS deduction records
        SSS sss1 = new SSS("24750-1000000", 1125);
        SSS sss2 = new SSS("2001-3000", 150);
        List<SSS> sssDeductionRecords = Arrays.asList(sss1, sss2);

        for (SSS sss : sssDeductionRecords) {
            String[] range = sss.getCompensationRange().split("-");
            double lowerBound = Double.parseDouble(range[0]);
            double upperBound = Double.parseDouble(range[1]);
    
            if (gross >= lowerBound && gross <= upperBound) {
                actualSSS = sss.getContribution(); // Accessing deduction directly
                break;
            }
        }
        
        // Assert the result
        assertEquals(expected, actualSSS, .001); // Assuming gross falls in the range of 1000-2000
    }
    
    @ParameterizedTest
    @CsvSource({
        "1000, 1000-2000, 100",
        "25000, 24750-1000000, 1125",
        "3000, 2001-3000, 150"
    })
    public void testCalculateParameterized(double gross, String range, double expected) {
        // Mock SSS deduction record
        SSS sss = new SSS(range, expected);
        
        double actualSSS = calculateSSSContribution(gross, sss);
        
        // Assert the result
        assertEquals(expected, actualSSS, .001);
    }
    
    private double calculateSSSContribution(double gross, SSS sss) {
        String[] range = sss.getCompensationRange().split("-");
        double lowerBound = Double.parseDouble(range[0]);
        double upperBound = Double.parseDouble(range[1]);
        
        if (gross >= lowerBound && gross <= upperBound) {
            return sss.getContribution(); // Accessing deduction directly
        }
        return 0; // Default to 0 if gross is out of range
    }
}
