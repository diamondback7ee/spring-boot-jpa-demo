package com.diamondback7ee.jpademo.repository;

import com.diamondback7ee.jpademo.entity.GradeEntity;
import org.springframework.data.repository.CrudRepository;


import java.util.List;
import java.util.Optional;

public interface GradeRepository extends CrudRepository<GradeEntity, Long> {
    Optional<GradeEntity> findByStudentEntityIdAndCourseEntityId(Long studentId, Long courseId);
    Optional<List<GradeEntity>> findByStudentEntityId(Long studentId);
    Optional<List<GradeEntity>> findByCourseEntityId(Long courseId);
    void deleteByStudentEntityIdAndCourseEntityId(Long studentId, Long courseId);
}
