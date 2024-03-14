/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.MotorPH;

/**
 *
 * @author Isaac
 */
public class Philhealth extends Calculation {
    
    private static double philhealthDeduction;

     public double calculate() {
        double gross = Grosswage.gross;
        double PhilDed;

        if (gross > 60000) { 
            PhilDed = 1800;
        } else {
            PhilDed = (gross * 0.03) / 2; //
        }

        philhealthDeduction = PhilDed; // Assign value to class-level variable
        return philhealthDeduction;
    }
}
