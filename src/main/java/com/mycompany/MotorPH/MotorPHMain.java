package com.mycompany.MotorPH;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MotorPHMain {
    
    private static Scanner scanner = new Scanner(System.in);
    
    static ArrayList<AttendanceRecord> attendanceRecords = AttendanceRecord.getAttendanceRecords();
    
    public static void main(String[] args) {
        System.out.println("Current Working Directory: " + System.getProperty("user.dir"));
        menu();
    }
    
    // Print main menu
    private static void menu(){
        int Resume = 1;  
    do{ 
        System.out.print("""
        ----- Motor PH MENU -----

        1: Show Employee Details
        2: Calculate Gross Wage
        3: Calculate Net Wage
        0: EXIT
        -------------------------
        CHOOSE: """);
        
        String detailSub;
        String ch = scanner.next();
 
        switch (ch){
            case "1":
                System.out.print("""
                ----- Motor PH MENU -----

                1: Individual Employee Details
                2: All Employee Details
                -------------------------
                Choose: """);
                detailSub = scanner.next();
                System.out.println("-------------------------");
                menu(detailSub);
                break;
                
            case "2":
                Calculation grosswage = new Grosswage();              
                grosswage.calculate();
                Grosswage.printGross();               
                break;
                
            case "3":
                Calculation netwage = new Netwage();              
                netwage.calculate();
                break;               
                
            case "0":
                System.exit(0);
                break;
            
            default:
                System.out.println("Invalid Input!");
                break;
        }
        
        System.out.println("back to menu? 1 = yes, 0 = no");
        Resume = scanner.nextInt();
        }while (Resume != 0);
    }
    
    // OVERLOAD MENU FOR SUBMENU IN PRINTING EMPLOYEE DETAILS
    private static void menu(String detailSub){
        // Option between all employee detail or one individual.
        switch (detailSub){
            case "1" -> printEmpSelectList();
            case "2" -> allEmployeeList();
        }
    }
    
    private static void printEmpSelectList() {
        List<Employee> employees = EmployeeModelFromFile.getEmployeeModelList();
        
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
        String empNum = scanner.next();
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
    List<Employee> employees = EmployeeModelFromFile.getEmployeeModelList();
                    
        for (Employee employee : employees) {
        System.out.println(employee);
        }
                
        System.out.println("-------------------------");
    }
}

