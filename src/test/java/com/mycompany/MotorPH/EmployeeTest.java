package com.mycompany.MotorPH;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class EmployeeTest {

    @Test
    public void testConstructor() {
        String[] data = { "123", "Doe", "John", "1990-01-01", "123 Street", "123456789", "SSS123", "PH123", "TIN123",
                "PAG123", "Active", "Manager", "Supervisor", "50000", "2000", "1000", "500", "50000", "10.5" };
        Employee employee = new Employee(data);

        // Check that fields are initialized correctly
        assertEquals("123", employee.getEmployeeNumber());
        assertEquals("Doe", employee.getLastName());
        assertEquals("John", employee.getFirstName());
        assertEquals("1990-01-01", employee.getBirthday());
        assertEquals("123 Street", employee.getAddress());
        assertEquals("123456789", employee.getPhoneNumber());
        assertEquals("SSS123", employee.getSssNumber());
        assertEquals("PH123", employee.getPhilhealthNumber());
        assertEquals("TIN123", employee.getTinNumber());
        assertEquals("PAG123", employee.getPagIbigNumber());
        assertEquals("Active", employee.getStatus());
        assertEquals("Manager", employee.getPosition());
        assertEquals("Supervisor", employee.getImmediateSupervisor());
        assertEquals("50000", employee.getBasicSalary());
        assertEquals("2000", employee.getRiceSubsidy());
        assertEquals("1000", employee.getPhoneAllowance());
        assertEquals("500", employee.getClothingAllowance());
        assertEquals("50000", employee.getGrossSemiMonthlyRate());
        assertEquals(10.5, employee.getHourlyRate());
    }
 @Test
public void testConstructorWithInvalidData() {
    // Test with invalid data (e.g., null values)
    String[] invalidData = {null, "", "John", "1990-01-01", "123 Street", "123456789", "SSS123", "PH123", "TIN123",
            "PAG123", "Active", "Manager", "Supervisor", "50000", "2000", "1000", "500", "50000", "10.5"};
    
    // Assert that IllegalArgumentException is thrown when invalid data is passed
    assertThrows(IllegalArgumentException.class, () -> new Employee(invalidData));
}


@Test
public void testConstructorWithExtremeValues() {
    // Test with extreme values or boundary conditions
    String[] extremeData = {"123", "Doe", "John", "1990-01-01", "123 Street", "123456789", "SSS123", "PH123",
            "TIN123", "PAG123", "Active", "Manager", "Supervisor", "999999999999", "2000", "1000", "500",
            "999999999999", "10.5"};
    Employee employee = new Employee(extremeData);

    // Assert that fields are initialized correctly
    assertEquals("999999999999", employee.getBasicSalary());
    // Add assertions for other fields if needed
}


    // Add more test methods as needed
}
