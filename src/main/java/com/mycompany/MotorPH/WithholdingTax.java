    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package com.mycompany.MotorPH;

    /**
     *
     * @author Isaac
     */
    public class WithholdingTax extends Calculation{
        public static double tax, taxableIncome, afterTax;
        
        @Override
        public double calculate(){
            Calculation sss = new SSS();
            Calculation philhealth = new Philhealth();
            Calculation pagibig = new Pagibig();           
            Calculation latePenalty = new LatePenalty();
            
            double totalDeduction = sss.calculate() + philhealth.calculate() + pagibig.calculate() + latePenalty.calculate();

            taxableIncome = Grosswage.gross - totalDeduction;

            if (taxableIncome <= 20832) {
                tax = 0;

            } else if (taxableIncome > 20832 && taxableIncome <= 33333) {
                tax = (taxableIncome - 20832) * 0.20;

            } else if (taxableIncome > 33333 && taxableIncome <= 66667) {
                tax = 2500 + (taxableIncome - 33333) * 0.25;

            } else if (taxableIncome > 66667 && taxableIncome <= 166667) {
                tax = 10833 + (taxableIncome - 66667) * 0.30;

            } else if (taxableIncome > 166667 && taxableIncome <= 666667) {
                tax = 40833.33 + (taxableIncome - 166667) * 0.32;

            } else {
                tax = 200833.33 + (taxableIncome - 666667) * 0.35;
            }
            
            double afterTax = taxableIncome - tax;
            
        return afterTax;
        }
        
        
        
        

    }
