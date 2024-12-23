package com.example.attendance.attendance.services;
import com.example.attendance.attendance.entities.*;
import com.example.attendance.attendance.repositories.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public boolean isAttendanceAlreadyRecorded(Student student, Subject subject, LocalDate date) {
        return attendanceRepository.findByStudentAndSubjectAndDate(student, subject, date).isPresent();
    }

    public void recordAttendance(Student student, Subject subject, boolean status) {
        Attendance attendance = new Attendance();
        attendance.setStudent(student);
        attendance.setSubject(subject);
        attendance.setDate(LocalDate.now());
        attendance.setStatus(status);

        attendanceRepository.save(attendance);
    }
}