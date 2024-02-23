package org.example.service;

import org.example.dao.GradeBookDao;
import org.example.dto.GradeBookDto;
import org.example.entity.GradeBook;
import org.example.entity.Student;
import org.example.entity.Subject;
import org.example.mapper.GradeBookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GradeBookService {
    private final GradeBookDao gradeBookDao;
    private final GradeBookMapper mapper;

    @Autowired
    public GradeBookService(GradeBookDao gradeBookDao, GradeBookMapper mapper) {
        this.gradeBookDao = gradeBookDao;
        this.mapper = mapper;
    }

    public GradeBookDto create(GradeBookDto newRecordDto){
        if (newRecordDto.id() != null) throw new IllegalStateException("Запись в журнале не создана, т.к. id не равен null");
        Date sqlDate = java.sql.Date.valueOf(newRecordDto.date());
        List<GradeBook> gradeBookRecord = gradeBookDao.readAll().stream()
                .filter(gb-> gb.getDate().toString().equals(sqlDate.toString()) &&
                        gb.getStudent().id()== newRecordDto.student().id() &&
                        gb.getSubject().name().equals(newRecordDto.subject().name()))
                .collect(Collectors.toList());
        if (!gradeBookRecord.isEmpty())
            throw new IllegalStateException("Запись в журнале на " + newRecordDto.date() + " для " +
                    newRecordDto.student().firstName() + " " + newRecordDto.student().lastName() +
                    " из класса: " + newRecordDto.student().studyClass().name() + "по предмету: " +
                    newRecordDto.subject().name() + "уже существует");
        else return mapper.toGradeBookDto(gradeBookDao.create(mapper.toGradeBookRecord(newRecordDto)));
    }

    public GradeBookDto read(long id){
        return mapper.toGradeBookDto(gradeBookDao.read(id));
    }

    public List<GradeBookDto> readAllByClass(String studyClass){
        return gradeBookDao.readAllByClass(studyClass).stream()
                .map(mapper::toGradeBookDto).toList();
    }

    public List<GradeBookDto> readAll(){
        return gradeBookDao.readAll().stream()
                .map(mapper::toGradeBookDto).toList();
    }

    public List<GradeBookDto> readAllByStudent(String firstName, String lastName){
        return gradeBookDao.readAllByStudent(firstName,lastName).stream()
                .map(mapper::toGradeBookDto).toList();
    };
    public List<GradeBookDto> readAllBySubject(String subject){
        return gradeBookDao.readAllBySubject(subject).stream()
                .map(mapper::toGradeBookDto).toList();
    }
    public List<GradeBookDto> readAllByDateAndClassAndSubject(LocalDate date, String studyClass, String subject){
        return gradeBookDao.readAllByDateAndClassAndSubject(date, studyClass, subject).stream()
                .map(mapper::toGradeBookDto).toList();
    }
    public GradeBookDto update(Long id, GradeBookDto newGradeBookDto){
        return mapper.toGradeBookDto(gradeBookDao.update(id, mapper.toGradeBookRecord(newGradeBookDto)));

    }
    public void delete(Long id){
       gradeBookDao.delete(id);
    }

    public boolean isExist(Long id){
        return gradeBookDao.isExist(id);
    }
}
