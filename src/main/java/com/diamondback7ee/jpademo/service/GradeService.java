package com.diamondback7ee.jpademo.service;

import com.diamondback7ee.jpademo.entity.CourseEntity;
import com.diamondback7ee.jpademo.entity.GradeEntity;
import com.diamondback7ee.jpademo.entity.StudentEntity;
import com.diamondback7ee.jpademo.model.Grade;
import com.diamondback7ee.jpademo.repository.CourseRepository;
import com.diamondback7ee.jpademo.repository.GradeRepository;
import com.diamondback7ee.jpademo.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class GradeService {
    @Autowired
    GradeRepository gradeRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    public Grade getGrade(Long studentId, Long courseId) {
        GradeEntity gradeEntity = gradeRepository.findByStudentEntityIdAndCourseEntityId(studentId, courseId).get();
        Grade grade = new Grade();
        BeanUtils.copyProperties(gradeEntity, grade);

        return grade;
    }

    public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
        StudentEntity studentEntity = studentRepository.findById(studentId).get();
        CourseEntity courseEntity = courseRepository.findById(courseId).get();

        GradeEntity gradeEntity = new GradeEntity();
        BeanUtils.copyProperties(grade, gradeEntity);
        gradeEntity.setStudentEntity(studentEntity);
        gradeEntity.setCourseEntity(courseEntity);

        gradeRepository.save(gradeEntity);
        return grade;
    }

    public Grade updateGrade(String score, Long studentId, Long courseId) {
        GradeEntity gradeEntity = gradeRepository.findByStudentEntityIdAndCourseEntityId(studentId, courseId).get();
        gradeEntity.setScore(score);
        gradeRepository.save(gradeEntity);
        return null;
    }

    public void deleteGrade(Long studentId, Long courseId) {
        gradeRepository.deleteByStudentEntityIdAndCourseEntityId(studentId, courseId);
    }

    public List<Grade> getStudentGrades(Long studentId) {
        List<GradeEntity> gradeEntities= gradeRepository.findByStudentEntityId(studentId).get();
        List<Grade> grades = new ArrayList<>();

        gradeEntities.forEach(gradeEntity -> {
            Grade grade = new Grade();
            BeanUtils.copyProperties(gradeEntity, grade);
            grades.add(grade);
        });
        return grades;
    }

    public List<Grade> getCourseGrades(Long courseId) {
        List<GradeEntity> gradeEntities= gradeRepository.findByCourseEntityId(courseId).get();
        List<Grade> grades = new ArrayList<>();

        gradeEntities.forEach(gradeEntity -> {
            Grade grade = new Grade();
            BeanUtils.copyProperties(gradeEntity, grade);
            grades.add(grade);
        });
        return grades;
    }

    public List<Grade> getAllGrades() {
        Iterable<GradeEntity> gradeEntities = gradeRepository.findAll();
        List<Grade> grades = new ArrayList<>();

        gradeEntities.forEach(gradeEntity -> {
            Grade grade = new Grade();
            BeanUtils.copyProperties(gradeEntity, grade);
            grades.add(grade);
        });
        return grades;
    }
}
