package com.diamondback7ee.jpademo.service;

import com.diamondback7ee.jpademo.entity.StudentEntity;
import com.diamondback7ee.jpademo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public StudentEntity getStudent(Long id) {
        return null;
    }

    public StudentEntity saveStudent(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    public void deleteStudent(Long id) {
    }

    public List<StudentEntity> getStudents() {
        return null;
    }
}
