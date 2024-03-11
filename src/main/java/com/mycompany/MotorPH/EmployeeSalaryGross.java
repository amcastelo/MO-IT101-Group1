/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.MotorPH;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *  
 * @author Isaac
 */

public class EmployeeSalaryGross extends Employee  {
    
    private static String empName;
    private static long hours;
    private static double gross, Hourly;
    private static double taxableIncome;
    private static int month;
    private static String empNum;
    static DecimalFormat df = new DecimalFormat("#.##");
    
    //CONSTRUCTOR
    public EmployeeSalaryGross(String[] data) {
        super(data); // Call the constructor of the superclass (Employee)
    }
    
    //CALCULATES GROSSWAGE
    public static void calculateGross() {          
            Scanner sc = new Scanner(System.in);
            System.out.println("-------------------------");
                System.out.print("Enter Employee #: ");              
                empNum = sc.next();
                System.out.println("-------------------------");
                System.out.println("Enter Month: ");
                month = sc.nextInt();
                System.out.println("-------------------------");

            // Read all rows from the txt file
            // Find the hourly rate for the chosen employee ID
            for (Employee employee : EmployeeModelFromFile.employees) {
                if (employee.getEmployeeNumber().equals(getEmpNum())) {
                    // Assuming the employee ID is in the first column, and hourly rate is in the last column
                    //setHourlyRate(employee.getHourlyRate());
                    setHourly(employee.getHourlyRate());
                    empName = employee.getFirstName() +" " + employee.getLastName();
                    // Remove commas from the hourly rate string
                    setHourly(getHourly());

                    // Check if the hourly rate string is a valid decimal number
                    if (isValidDecimal(Double.toString(getHourly()))) {
                        double HourlyRate = getHourly();
                        long hour = AttendanceRecord.calculateTotalHoursAndPrint(2022, getMonth(), getEmpNum());
                        double hoursCalculated = HourlyRate * hour;
                        
                        setHours(hour);
                        setGross(hoursCalculated);
                        
                        printGross();
                    } else {
                        System.out.println("Invalid hourly rate for Employee ID " + getEmpNum() + ": " + getHourly());
                        System.out.println(); // Move to the next line for the next row
                    }                                              
                        
                    return; // Exit the loop once the employee is found
                }                               
            }
            
            // If the loop completes without finding the employee ID
            System.out.println("Employee ID " + getEmpNum() + " not found.");
       
    }
    
    //PRINTS GROSS WAGE
    private static void printGross(){
        System.out.println("""
                ------------------------------------------           
                Employee ID: %s
                Name: %s
                Hourly Rate: $%.2f
                Total Hours: %s
                Gross Wage: $%s
                ------------------------------------------
                """.formatted(getEmpNum(), 
                    getEmpName(),
                    getHourly(),
                    getHours(), 
                    df.format(gross)
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
    

    //GETTER & SETTERS HERE ONWARDS
    /**
     * @return the hourlyRateString
     */
    public static double getHourly() {
        return Hourly;
    }


    /**
     * @return the gross
     */
    public static double getGross() {
        return gross;
    }


    /**
     * @param aGross the gross to set
     */
    public static void setGross(double aGross) {
        gross = aGross;
    }

    /**
     * @return the taxableIncome
     */
    public static double getTaxableIncome() {
        return taxableIncome;
    }

    /**
     * @param aTaxableIncome the taxableIncome to set
     */
    public static void setTaxableIncome(double aTaxableIncome) {
        taxableIncome = aTaxableIncome;
    }

    /**
     * @return the empName
     */
    public static String getEmpName() {
        return empName;
    }

    /**
     * @return the hours
     */
    public static long getHours() {
        return hours;
    }

    /**
     * @param aHours the hours to set
     */
    public static void setHours(long aHours) {
        hours = aHours;
    }

    /**
     * @param aHourly
     */
    public static void setHourly(double aHourly) {
        Hourly = aHourly;
    }

    /**
     * @return the empNum
     */
    public static String getEmpNum() {
        return empNum;
    }

    /**
     * @return the month
     */
    public static int getMonth() {
        return month;
    }

   
      
}
