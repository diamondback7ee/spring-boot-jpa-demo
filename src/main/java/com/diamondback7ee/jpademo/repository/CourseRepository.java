package com.diamondback7ee.jpademo.repository;

import com.diamondback7ee.jpademo.entity.CourseEntity;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<CourseEntity, Long>{
}
