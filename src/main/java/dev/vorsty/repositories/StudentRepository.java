package dev.vorsty.repositories;

import dev.vorsty.dto.Student;
import org.springframework.data.repository.ListCrudRepository;

public interface StudentRepository extends ListCrudRepository<Student, Long> {

}

