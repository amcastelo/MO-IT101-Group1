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
    
    @Override
    public double calculate(){
        double gross = Grosswage.gross;

            double PhilDed = (gross * .03)/2;

            return philhealthDeduction = PhilDed;
    }
    
}
