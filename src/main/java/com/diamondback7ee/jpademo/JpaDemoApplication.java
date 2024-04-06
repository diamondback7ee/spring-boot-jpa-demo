package com.diamondback7ee.jpademo;

import com.diamondback7ee.jpademo.entity.StudentEntity;
import com.diamondback7ee.jpademo.model.Student;
import com.diamondback7ee.jpademo.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {
    @Autowired
    StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Student> students = List.of(new Student("Harry Potter", LocalDate.parse(("1980-07-31"))),
                new Student("Ron Weasley", LocalDate.parse(("1980-03-01"))),
                new Student("Hermione Granger", LocalDate.parse(("1979-09-19"))),
                new Student("Neville Longbottom", LocalDate.parse(("1980-07-30")))
        );

        List<StudentEntity> studentEntities = new ArrayList<>();

        students.forEach(student -> {
            StudentEntity studentEntity = new StudentEntity();
            BeanUtils.copyProperties(student, studentEntity);
            studentEntities.add(studentEntity);

        });
        studentRepository.saveAll(studentEntities);
    }
}
