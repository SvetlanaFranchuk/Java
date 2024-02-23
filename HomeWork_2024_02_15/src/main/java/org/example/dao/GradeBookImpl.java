package org.example.dao;

import org.example.entity.GradeBook;
import org.example.entity.Student;
import org.example.entity.Subject;
import org.example.mapper.GradeBookDaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class GradeBookImpl implements GradeBookDao{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GradeBookImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public GradeBook create(GradeBook gradeBook) {
       Objects.requireNonNull(gradeBook);
       //TODO надо еще проверять, что ИД студента и предмета существуют в базе
       jdbcTemplate.update("INSERT INTO grade_book (date, student, subject, grade) " +
               "values ('"+ gradeBook.getDate() +"', ?, ?, ?);",
               gradeBook.getStudent().id(),
               gradeBook.getSubject().ordinal()+1, gradeBook.getGrade());
       return readAll().stream().max((o1, o2) -> o1.getId().compareTo(o2.getId())).orElseThrow();
    }

    @Override
    public GradeBook read(Long id) {
        List<GradeBook> gradeBooks = jdbcTemplate.query(getFullSelect() + " WHERE grade_book.id=?;",
                                     new GradeBookDaoMapper(), id);
        if(gradeBooks.size()>1) throw new IllegalStateException("id more than one");
        return gradeBooks.stream().findFirst().orElseThrow();
    }

    @Override
    public List<GradeBook> readAllByClass(String studyClass) {
        List<GradeBook> gradeBooks = jdbcTemplate.query(getFullSelect() + " where study_classes.name= ?;",
                new GradeBookDaoMapper(), studyClass);
        return gradeBooks;
    }

    @Override
    public List<GradeBook> readAll() {
        List<GradeBook> gradeBooks = jdbcTemplate.query(getFullSelect(), new GradeBookDaoMapper());
        return gradeBooks;
    }

    @Override
    public List<GradeBook> readAllByStudent(String firstName, String lastName) {
        List<GradeBook> gradeBooks = jdbcTemplate.query(getFullSelect() +
                        " where students.firstname= ? and students.lastname= ?;",
                new GradeBookDaoMapper(), firstName, lastName);
        return gradeBooks;
    }

    @Override
    public List<GradeBook> readAllBySubject(String subject) {
        List<GradeBook> gradeBooks = jdbcTemplate.query(getFullSelect() + " where subjects.name= ?;",
                new GradeBookDaoMapper(), subject);
        return gradeBooks;
    }

    @Override
    public List<GradeBook> readAllByDateAndClassAndSubject(LocalDate date, String studyClass, String subject) {
        List<GradeBook> gradeBooks = jdbcTemplate.query(getFullSelect() +
                        " where date=? and study_classes.name=? and subjects.name=?",
                new GradeBookDaoMapper(), date, studyClass, subject);
        return gradeBooks;
    }

    @Override
    public GradeBook update(Long id, GradeBook newGradeBook) {
        Objects.requireNonNull(newGradeBook);
        Date sqlDate = java.sql.Date.valueOf(newGradeBook.getDate());
        //TODO надо еще проверять, что ИД студента и предмета существуют в базе
        jdbcTemplate.update("UPDATE grade_book SET date=?, student=?, subject=?, grade=? WHERE grade_book.id=?",
                sqlDate, newGradeBook.getStudent().id(),
                newGradeBook.getSubject().ordinal()+1, newGradeBook.getGrade(), id);
        return read(id);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM grade_book WHERE grade_book.id=?", id);
    }

    @Override
    public List<GradeBook> findByAllParameters(LocalDate date, long idStudent, String subject) {
        Date sqlDate = java.sql.Date.valueOf(date);
        List<GradeBook> gradeBooks = jdbcTemplate.query(getFullSelect() +
                        " where date=? and students.id=? and subjects.name=?",
                new GradeBookDaoMapper(), sqlDate, idStudent, subject);
        return gradeBooks;
    }

    @Override
    public boolean isExist(Long id) {
        return !jdbcTemplate.query(getFullSelect() + " where grade_book.id = ?", new GradeBookDaoMapper(), id)
                .isEmpty();
    }

    private String getFullSelect(){
        return  "SELECT grade_book.id, grade_book.date, " +
                        " students.id AS studentID , students.firstname, students.lastname, " +
                        " study_classes.id as classId, study_classes.name as study_class, " +
                        " subjects.id as subjectId, subjects.name as subject, grade_book.grade " +
                        " FROM grade_book " +
                        " inner join subjects on subjects.id = grade_book.subject " +
                        " inner join students on students.id=grade_book.student " +
                        " inner join study_classes on study_classes.id=students.studyclass";
    }
}
