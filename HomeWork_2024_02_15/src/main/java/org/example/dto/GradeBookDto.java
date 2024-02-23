package org.example.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.Student;
import org.example.entity.StudyClass;
import org.example.entity.Subject;

import java.time.LocalDate;

public record GradeBookDto (
    @Min(0) Long id,
    @NotNull(message="Date can`t be empty")
    @PastOrPresent(message="Date can be in past or present")
    LocalDate date,

    @NotNull(message="Student can`t be empty")
    Student student,

    @NotNull(message="Subject can`t be empty")
    Subject subject,

    @NotNull(message="Grade can`t be empty")
    @Min(value = 1, message ="Min value for grade is 1")
    @Max(value = 12, message ="Max value for grade is 12")
    int grade
){}
