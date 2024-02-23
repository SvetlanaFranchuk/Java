package org.example.dao;

import org.example.entity.GradeBook;
import org.example.entity.Student;
import org.example.entity.Subject;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface GradeBookDao {
    GradeBook create(GradeBook gradeBook);
    GradeBook read(Long id);
    List<GradeBook> readAll();
    List<GradeBook> findByAllParameters(LocalDate date, long idStudent, String subject);
    List<GradeBook> readAllByClass(String studyClass);
    List<GradeBook> readAllByStudent(String firstName, String lastName);
    List<GradeBook> readAllBySubject(String subject);
    List<GradeBook> readAllByDateAndClassAndSubject(LocalDate date, String studyClass, String subject);
    GradeBook update(Long id, GradeBook newGradeBook);
    void delete(Long id);
    boolean isExist(Long id);
}
