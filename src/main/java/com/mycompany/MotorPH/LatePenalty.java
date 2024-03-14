/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.MotorPH;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Isaac
 */
public class LatePenalty extends Calculation{
    
    @Override
    public double calculate(){
    double totalLateDeduction = 0;
    
    // Iterates through every attendance record.
    for (AttendanceRecord attendanceRecord : AttendanceRecord.attendanceRecords) {
        // Check if the record is for the target employee.
        if (attendanceRecord.getId().equals(Grosswage.getTargetEmployeeID())) {
            LocalDate recordDate = attendanceRecord.getDate();
            int recordMonth = recordDate.getMonthValue(); // Month as an integer.

            // Check if the record is in the target month
            if (recordMonth == Grosswage.getTargetMonth()) {
                // Assuming late penalty starts from 8:10 AM (490 minutes) onwards
                final int lateThreshold = 490;
                
                // Gets time in.
                LocalTime timeIn = attendanceRecord.getTimeIn();
                
                // converts hour into minutes then add it to the minutes. Sample: 8:40 is 480 + 40.
                int lateTime = timeIn.getHour() * 60 + timeIn.getMinute();
                
                // Compares late time to threshold.
                if (lateTime >= lateThreshold) {
                    // Calculate the per-minute equivalent of the hourly rate
                    double hourlyRate = Grosswage.getHourly();
                    double perMinuteRate = hourlyRate / 60.0;

                    // Calculate the deduction amount based on late time
                    double deduction = perMinuteRate * (lateTime - lateThreshold);

                    // Ensure deduction is non-negative
                    totalLateDeduction += Math.max(0, deduction);

                }

                System.out.println("Late ID" + Grosswage.getTargetEmployeeID());
                System.out.println("month" + Grosswage.getTargetMonth());
                // You can add more logic here if needed, such as printing details for each record
            }
        }
    }

    return totalLateDeduction;
    }
}
