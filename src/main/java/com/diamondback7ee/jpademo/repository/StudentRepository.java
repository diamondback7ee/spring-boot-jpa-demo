package com.diamondback7ee.jpademo.repository;

import com.diamondback7ee.jpademo.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
