package org.example.mapper;

import org.example.entity.GradeBook;
import org.example.entity.Student;
import org.example.entity.StudyClass;
import org.example.entity.Subject;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class GradeBookDaoMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
          Subject subject = Subject.valueOf(rs.getString("subject"));

          StudyClass studyClass = StudyClass.valueOf(rs.getString("study_class"));

          Student student = new Student(rs.getLong("studentId"),
                rs.getString("firstName"),
                rs.getString("lastName"), studyClass);

        return new GradeBook(rs.getLong("id"), rs.getDate("date").toLocalDate(),
                student, subject, rs.getInt("grade"));

    }
}
