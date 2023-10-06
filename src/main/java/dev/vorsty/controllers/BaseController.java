package dev.vorsty.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import dev.vorsty.dto.Student;
import dev.vorsty.repositories.StudentRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping("api/base")
public class BaseController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("check")
    public String getAllUsers(){
        return "Hello World!" + new Date();
    }

    @GetMapping()
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @PostMapping(value = "", produces = APPLICATION_JSON_VALUE)
    public Student createStudent(@RequestBody Student newStudent) {
        return addStudent(newStudent);
    }

    @PutMapping(value = "", produces= APPLICATION_JSON_VALUE)
    public Student changeStudent(@RequestBody Student changingStudent){
        return updateStudent(changingStudent);
    }

    @DeleteMapping(value = "{id}", produces = APPLICATION_JSON_VALUE)
    public Long deleteStudent(@PathVariable("id")Long id) {
        return removeStudent(id);
    }

    private Student updateStudent(Student student) {
        if (student.getId() == null) {
            throw new RuntimeException("id of changing student cannot be null");
        }
        Student changingStudent = studentRepository.findAll().stream()
                .filter(el -> el.getId().equals(student.getId()))
                .findFirst().orElseThrow(() -> new RuntimeException("student with id: " + student.getId() + " not found"));

        changingStudent.setName(student.getName());
        changingStudent.setSurname(student.getSurname());
        studentRepository.save(changingStudent);

        return student;
    }

    private Student addStudent(Student student){
        studentRepository.save(student);
        return student;
    }

    private Long removeStudent(Long id){
        studentRepository.findAll().removeIf(el -> el.getId().equals(id));
        studentRepository.deleteById(id);
        return id;
    }
}
