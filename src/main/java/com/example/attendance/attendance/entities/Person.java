package com.example.attendance.attendance.entities;

import jakarta.persistence.*;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Person {
    private String name;

    @Id
    private Integer idc;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}