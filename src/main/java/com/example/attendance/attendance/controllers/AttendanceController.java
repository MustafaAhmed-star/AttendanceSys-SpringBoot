package com.example.attendance.attendance.controllers;

import com.example.attendance.attendance.entities.*;
import com.example.attendance.attendance.repositories.*;
import com.example.attendance.attendance.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.attendance.attendance.dto.AttendanceRequest;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/{subjectId}")
    public ResponseEntity<List<Student>> getAttendanceForm(@PathVariable Long subjectId) {
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid subject ID"));
        List<Student> students = studentRepository.findBySubjects(subject);

        return ResponseEntity.ok(students);  
    }

    @PostMapping("/{subjectId}")
    public ResponseEntity<String> submitAttendance(
            @PathVariable Long subjectId,
            @RequestBody AttendanceRequest attendanceRequest) { 

        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid subject ID"));

        boolean alreadyRecorded = false;

        for (Integer studentId : attendanceRequest.getStudentIds()) {
            String attendanceStatus = attendanceRequest.getAttendanceData().get("attendance_" + studentId);
            Student student = studentRepository.findById(studentId)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid student ID"));

            if (attendanceService.isAttendanceAlreadyRecorded(student, subject, LocalDate.now())) {
                alreadyRecorded = true;
                continue;
            }

            attendanceService.recordAttendance(student, subject, attendanceStatus.equals("present"));
        }

        if (alreadyRecorded) {
            return ResponseEntity.status(400).body("Attendance for some students was already recorded today.");
        } else {
            return ResponseEntity.status(200).body("Attendance recorded successfully.");
        }
    }
}
