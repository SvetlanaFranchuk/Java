package org.example.controller;

import jakarta.validation.Valid;
import org.example.dto.GradeBookDto;
import org.example.entity.Student;
import org.example.entity.Subject;
import org.example.service.GradeBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@RestController
@Validated
@RequestMapping(path="/gradeBook")
public class GradeBookController {
  private final GradeBookService gradeBookService;

  @Autowired
  public GradeBookController(GradeBookService gradeBookService) {
        this.gradeBookService = gradeBookService;
  }

  @PostMapping("/newRecord")
  public GradeBookDto create(@RequestBody @Valid GradeBookDto newGradeBookDto){
     return gradeBookService.create(newGradeBookDto);
  }

  @GetMapping("/readOne/{id}")
  public GradeBookDto read(@PathVariable("id") long id){
      if (!gradeBookService.isExist(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Can't find record with id=" + id);
      else return gradeBookService.read(id);
  }

  @GetMapping("/readByClass/{studyClass}")
  public List<GradeBookDto> readAllByClass(@PathVariable("studyClass") String studyClass){
      return gradeBookService.readAllByClass(studyClass);
  }

  @GetMapping()
  public List<GradeBookDto> readAll(){
      return gradeBookService.readAll();
  }

  @GetMapping("/readByStudent/{firstName}/{lastName}")
  public List<GradeBookDto> readAllByStudent(@PathVariable("firstName") String firstName,
                                             @PathVariable("lastName") String lastName){
      return gradeBookService.readAllByStudent(firstName, lastName);
  };
  @GetMapping("/readBySubject/{subject}")
  public List<GradeBookDto> readAllBySubject(@PathVariable("subject") String subject){
      return gradeBookService.readAllBySubject(subject);
  };
  @GetMapping("/readByDateClassSubject/{date}/{studyClass}/{subject}")
  public List<GradeBookDto> readAllByDateAndClassAndSubject(@PathVariable("date") LocalDate date,
                                                            @PathVariable("studyClass") String studyClass,
                                                            @PathVariable("subject") String subject){
      return gradeBookService.readAllByDateAndClassAndSubject(date, studyClass, subject);
  };
  @PutMapping("/update/{id}")
  public GradeBookDto update(@PathVariable("id") Long id, @RequestBody @Valid GradeBookDto newGradeBookDto){
      return gradeBookService.update(id, newGradeBookDto);
  };
  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id") Long id){
    if (!gradeBookService.isExist(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Can't find record with id=" + id);
    else gradeBookService.delete(id);
  }
}
