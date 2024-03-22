package com.mycompany.MotorPH;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class AttendanceRecordTest {

    @Test
    void testLoadAttendance() {
        // Prepare test data
        String testData = "123,Doe,John,01/01/2024,08:00,17:00\n";
        // Add more test data if needed

        // Create a temporary test file
        File tempFile = createTempFile(testData);

        // Set the test file path to the temporary file
        String testFilePath = tempFile.getAbsolutePath();
        AttendanceRecord.setTXT_FILE_PATH(testFilePath);

        // Load attendance records
        ArrayList<AttendanceRecord> attendanceRecords = AttendanceRecord.loadAttendance();

        // Assertions
        assertEquals(1, attendanceRecords.size()); // Assuming one attendance record is loaded
        AttendanceRecord attendanceRecord = attendanceRecords.get(0);
        assertEquals("123", attendanceRecord.getId());
        assertEquals("Doe John", attendanceRecord.getName());
        assertEquals(LocalDate.of(2024, 1, 1), attendanceRecord.getDate());
        assertEquals(LocalTime.of(8, 0), attendanceRecord.getTimeIn());
        assertEquals(LocalTime.of(17, 0), attendanceRecord.getTimeOut());

        // Clean up: Delete the temporary test file
        tempFile.delete();
    }

    // Helper method to create a temporary test file
    private File createTempFile(String testData) {
        try {
            File tempFile = File.createTempFile("tempAttendance", ".txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            writer.write("Employee ID,Last Name,First Name,Date,Time In,Time Out\n"); // Header
            writer.write(testData);
            writer.close();
            return tempFile;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
