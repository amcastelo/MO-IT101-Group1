/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.MotorPH;

/**
 *
 * @author Isaac
 */
public class Pagibig extends Calculation {
    private static double pagibigDeduction;
    
    @Override
    public double calculate(){
        double gross = Grosswage.gross;
        double pagibig;

        //Conditional statement for pagibig range.
        if (gross > 1000.00 && gross <= 1500.00) {
            pagibig = gross * 0.03;
        } else {
            pagibig = gross * 0.04;     
        }
        
        //Maximum amount must not exceed 100.
        if (pagibig > 100) {
            pagibig = 100;
        }
        return pagibigDeduction = pagibig;
    }
    
}
