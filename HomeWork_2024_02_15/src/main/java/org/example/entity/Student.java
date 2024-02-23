package org.example.entity;

import java.time.LocalDate;

public record Student(long id, String firstName, String lastName, StudyClass studyClass) {
}
