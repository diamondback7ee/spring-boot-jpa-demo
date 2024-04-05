package com.diamondback7ee.jpademo.service;

import com.diamondback7ee.jpademo.entity.StudentEntity;
import com.diamondback7ee.jpademo.model.Student;
import com.diamondback7ee.jpademo.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        StudentEntity studentEntity = new StudentEntity();
        BeanUtils.copyProperties(student, studentEntity);
        studentRepository.save(studentEntity);
        return student;
    }

    public Student getStudent(Long id) {
        StudentEntity studentEntity = studentRepository.findById(id).get();
        Student student = new Student();
        BeanUtils.copyProperties(studentEntity, student);
        return student;
    }


    public void deleteStudent(Long id) {
    }

    public List<Student> getStudents() {
        Iterable<StudentEntity> studentEntities = studentRepository.findAll();
        List<Student> students = new ArrayList<>();

        studentEntities.forEach(studentEntity -> {
            Student student = new Student();
            BeanUtils.copyProperties(studentEntity, student);
            students.add(student);
        });

        return students;
    }
}
