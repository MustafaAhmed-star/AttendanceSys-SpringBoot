package com.example.attendance.attendance.repositories;

import com.example.attendance.attendance.entities.Attendance;
import com.example.attendance.attendance.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;


@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    Optional<Attendance> findByStudentAndSubjectAndDate(Student student, Subject subject, LocalDate date);
}