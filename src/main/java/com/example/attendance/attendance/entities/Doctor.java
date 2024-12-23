package com.example.attendance.attendance.entities;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.Set;
import java.util.HashSet;


@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Doctor extends Person {
    @ManyToMany
    @JoinTable(name = "doctor_subject")
    private Set<Subject> subjects = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "doctor_level")
    private Set<Level> levels = new HashSet<>();
}