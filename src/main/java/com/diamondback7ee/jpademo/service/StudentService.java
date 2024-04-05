package com.diamondback7ee.jpademo.service;

import com.diamondback7ee.jpademo.entity.Student;
import com.diamondback7ee.jpademo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student getStudent(Long id) {
        return null;
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
    }

    public List<Student> getStudents() {
        return null;
    }
}
