package com.example.attendance.attendance.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.attendance.attendance.entities.*;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}