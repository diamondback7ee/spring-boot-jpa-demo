package com.diamondback7ee.jpademo.repository;

import com.diamondback7ee.jpademo.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<StudentEntity, Long> {
}
