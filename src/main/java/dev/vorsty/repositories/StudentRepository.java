package dev.vorsty.repositories;

import dev.vorsty.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

public interface StudentRepository extends ListCrudRepository<Student, Long> {
}

