package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class GradeBook {
    private Long id;
    private LocalDate date;
    private Student student;
    private Subject subject;
    private int grade;
}
