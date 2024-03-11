package com.mycompany.MotorPH;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MotorPHMain {
    
    private static int platform = 1;
    private static EmployeeModel employeeModel;
    
    private static Scanner sc = new Scanner(System.in);
    private static Scanner inputPlatform = new Scanner(System.in);
    
    static ArrayList<AttendanceRecord> attendanceRecords = AttendanceRecord.getAttendanceRecords();
    
    public static void main(String[] args) {
        System.out.println("Current Working Directory: " + System.getProperty("user.dir"));
        getDefaultEmployeeModel();
        menu();
    }
    
    //PRINT MAIN MENU LOOP AFTER EVERY ACTION
    private static void menu(){
        int Resume = 1;  
    do{ 
        System.out.print("""
        ----- Motor PH MENU -----

        1: Show Employee Details
        2: Calculate Gross Wage
        3: Calculate Net Wage
        4: Choose platform
        0: EXIT
        -------------------------
        CHOOSE: """);
        
        String detailSub;
        String ch = sc.next();
 
        switch (ch){
            case "1":
                System.out.print("""
                ----- Motor PH MENU -----

                1: Individual Employee Details
                2: All Employee Details
                -------------------------
                Choose: """);
                detailSub = sc.next();
                System.out.println("-------------------------");
                menu(detailSub);
                break;
                
            case "2":
                EmployeeSalaryGross.calculateGross();               
                break;
                
            case "3":              
                NetWageCalculation.calculateNetWage();
                break;
                
            case "4":
                platformSwitch();
                break;
                
            case "5":
                NetWageCalculation.printSSSDeductionRecords();
                break;
                
            case "0":
                System.exit(0);
                break;
            
            default:
                System.out.println("Invalid Input!");
                break;
        }
        
        System.out.println("back to menu? 1 = yes, 0 = no");
        Resume = sc.nextInt();
        }while (Resume != 0);
    }
    
    //OVERLOAD MENU FOR SUBMENU IN PRINTING EMPLOYEE DETAILS
    private static void menu(String detailSub){       
        switch (detailSub){
            case "1" -> printEmpSelectList();
            case "2" -> allEmployeeList();
        }
    }
    
    //SWITCHES WHICH PLATFORM TO LOAD EMPLOYEE DATA FROM
    private static void platformSwitch(){
    System.out.println("Choose from which platform to load employee data:");
    System.out.print("""
                ----- Motor PH MENU -----

                1: Load from File
                2: Load from class
                -------------------------
                Choose: """);
                    
                String optionPlatform = inputPlatform.next();
                    
                    switch (optionPlatform) {
                    case "1" -> platform = 1;
                    
                    case "2" -> platform = 2;
                    
                    default -> {}
                    }
                    
                getDefaultEmployeeModel();            
    }
    
    private static void printEmpSelectList() {
        List<Employee> employees = employeeModel.getEmployeeModelList();
        
        System.out.println("""
                   -------------------------
                   |     Employee List     |
                   -------------------------""");

        String format = "%-15s%-20s"; // Adjust the width as needed

        for (Employee employee : employees) {
            System.out.printf(format, employee.getEmployeeNumber(), employee.getLastName());
            System.out.println(); // Print a new line            
        }
        
        System.out.println("-------------------------");
        System.out.print("Enter Employee #: ");              
        String empNum = sc.next();
        System.out.println("-------------------------");
        
        for (Employee employee : employees) {
            if (employee.getEmployeeNumber().equals(empNum)) {
                System.out.println("Employee Details for Employee ID " + empNum + ":" + '\n' +
                                   "-------------------------");
                System.out.println(employee.toString(true));
                System.out.println("-------------------------");
                return;
            }
        }

        System.out.println("Employee ID " + empNum + " not found.");
    }
    
    private static void allEmployeeList() {
    List<Employee> employees = employeeModel.getEmployeeModelList();
                    
        for (Employee employee : employees) {
        System.out.println(employee);
        }
                
        System.out.println("-------------------------");
    }
    
    //SETS DEFAULT EMPLOYEE MODEL LOADED
    private static void getDefaultEmployeeModel() {
        if (platform == 1) {
            employeeModel = new EmployeeModelFromFile();
        } else {
            employeeModel = new EmployeeModelFromClass();
        }
    }
}

