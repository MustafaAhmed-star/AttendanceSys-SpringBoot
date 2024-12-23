package com.example.attendance.attendance.entities;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.Set;
import java.util.HashSet;
import lombok.Getter;
import lombok.Setter;
@Entity
@Data
@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
public class Student extends Person {
    @ManyToOne
    @JoinColumn(name = "level_id")
    private Level level;

    @ManyToMany
    @JoinTable(name = "student_subject")
    private Set<Subject> subjects = new HashSet<>();
}