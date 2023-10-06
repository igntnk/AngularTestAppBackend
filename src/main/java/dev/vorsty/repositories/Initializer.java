package dev.vorsty.repositories;

import dev.vorsty.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Initializer {

    @Autowired
    private StudentRepository studentrepository;

    public void initial() {
        studentrepository.save(new Student("ignat","ilyenko"));
        studentrepository.save(new Student("kirill","bezugly"));
        studentrepository.save(new Student("danyl","svinoykhov"));
        studentrepository.save(new Student("andrey","abramov"));

    }
}
