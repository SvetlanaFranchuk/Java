package org.example.mapper;

import org.example.dto.GradeBookDto;
import org.example.entity.GradeBook;
import org.springframework.stereotype.Component;

@Component
public class GradeBookMapper {

    public GradeBook toGradeBookRecord(GradeBookDto gradeBookDto) {
        return new GradeBook(gradeBookDto.id(), gradeBookDto.date(), gradeBookDto.student(),
                 gradeBookDto.subject(), gradeBookDto.grade());
    }

    public GradeBookDto toGradeBookDto(GradeBook gradeBook) {
        return new GradeBookDto(gradeBook.getId(), gradeBook.getDate(), gradeBook.getStudent(),
                 gradeBook.getSubject(), gradeBook.getGrade());
    }

}
