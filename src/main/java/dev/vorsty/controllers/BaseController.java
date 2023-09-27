package dev.vorsty.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dev.vorsty.dto.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/base")
public class BaseController {

    private Long counter = 0L;

    private Long generateId(){
        return counter++;
    }

    List<Student> students;
    @PostConstruct
    private void init(){
        students = new ArrayList();
        students.add(new Student(generateId(),"Ivan","VM","+7"));
        students.add(new Student(generateId(),"Ivan2","VM","+8"));
        students.add(new Student(generateId(),"Ivan3","AM","+9"));
    }

    @GetMapping("check")
    public String getAllUsers(){
        return "Hello World!" + new Date();
    }

    @GetMapping("students")
    public List<Student> getAllStudents(){
        return students;
    }

    @PostMapping(value = "students", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Student createStudent(@RequestBody Student newStudent) {
        return addStudent(newStudent);
    }

    private Student addStudent(Student student){
        student.setId(generateId());
        students.add(student);
        return student;
    }
}
