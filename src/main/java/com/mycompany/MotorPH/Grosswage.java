/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.MotorPH;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Isaac
 */
public class Grosswage extends Calculation{

    public static String targetEmployeeID;
    public static String employeeName;
    private static String employeeID;
    public static int targetMonth;
    public static double gross;
    private static double hourly;
    public static double hours;
    
    @Override
    public double calculate(){
        List<Employee> employees = EmployeeModelFromFile.getEmployeeModelList();       
            Scanner sc = new Scanner(System.in);
            
            // Asks for User Input.
                System.out.println("-------------------------");
                System.out.print("Enter Employee #: ");              
                targetEmployeeID = sc.next();
                System.out.println("-------------------------");
                System.out.println("Enter Month: ");
                targetMonth = sc.nextInt();
                System.out.println("-------------------------");

            // Read all rows from the txt file
            // Find the hourly rate for the chosen employee ID
            for (Employee employee : employees) {
                if (employee.getEmployeeNumber().equals(getTargetEmployeeID())) {
                    // Assuming the employee ID is in the first column, and hourly rate is in the last column
                    //setHourlyRate(employee.getHourlyRate());
                    setHourly(employee.getHourlyRate());
                    //employeeName = employee.getFirstName() +" " + employee.getLastName();
                    // Remove commas from the hourly rate string
                    setHourly(getHourly());
                    employeeID = employee.getEmployeeNumber();
                    // Check if the hourly rate string is a valid decimal number
                    if (isValidDecimal(Double.toString(getHourly()))) {
                        double HourlyRate = employee.getHourlyRate();
                        long hour = AttendanceRecord.calculateTotalHoursAndPrint(2022, getTargetMonth(), getTargetEmployeeID());
                        double hoursCalculated = HourlyRate * hour;
                        
                        setHourly(HourlyRate);
                        hours = hour;
                        gross = hoursCalculated;
                        employeeName = employee.getFirstName() + employee.getLastName();
                        //printGross(employee.getEmployeeNumber(), employeeName, HourlyRate, hour, gross);
                    } else {
                        System.out.println("Invalid hourly rate for Employee ID " + getEmployeeID() + ": " + getHourly());
                        System.out.println(); // Move to the next line for the next row
                    }                                              
                        
                    return gross; // Exit the loop once the employee is found
                }                               
            }
            
            // If the loop completes without finding the employee ID
            System.out.println("Employee ID " + getEmployeeID() + " not found.");
        return gross;
    }
    
    public static void printGross(){
        System.out.println("""
                ------------------------------------------           
                Employee ID: %s
                Name: %s
                Hourly Rate: $%.2f
                Total Hours: %s
                Gross Wage: $%s
                ------------------------------------------
                """.formatted(getEmployeeID(), 
                    employeeName, getHourly(),
                    hours, 
                    decimalFormat.format(gross)
                ));
    }
    
    //CHECKS IF DECIMAL IN HOURLY RATE IS VALID
    private static boolean isValidDecimal(String str) {
        try {
        Double.parseDouble(str);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}

    /**
     * @return the targetEmployeeID
     */
    public static String getTargetEmployeeID() {
        return targetEmployeeID;
    }

    /**
     * @return the targetMonth
     */
    public static int getTargetMonth() {
        return targetMonth;
    }

    /**
     * @return the employeeID
     */
    public static String getEmployeeID() {
        return employeeID;
    }

    /**
     * @return the hourly
     */
    public static double getHourly() {
        return hourly;
    }

    /**
     * @param aHourly the hourly to set
     */
    public static void setHourly(double aHourly) {
        hourly = aHourly;
    }
}
