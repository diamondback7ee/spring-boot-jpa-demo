package com.diamondback7ee.jpademo;

import com.diamondback7ee.jpademo.entity.CourseEntity;
import com.diamondback7ee.jpademo.entity.StudentEntity;
import com.diamondback7ee.jpademo.model.Course;
import com.diamondback7ee.jpademo.model.Student;
import com.diamondback7ee.jpademo.repository.CourseRepository;
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

    @Autowired
    CourseRepository courseRepository;

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

        List<Course> courses = List.of(new Course("Charms", "CH104", "In this class, you will learn spells concerned with giving an object new and unexpected properties."),
                new Course("Defence Against the Dark Arts", "DADA", "In this class, you will learn defensive techniques against the dark arts."),
                new Course("Herbology", "HB311", "In this class, you will learn the study of magical plants and how to take care of, utilise and combat them."),
                new Course("History of Magic", "HIS393", "In this class, you will learn about significant events in wizarding history."),
                new Course("Potions", "POT102", "In this class, you will learn correct mixing and stirring of ingredients to create mixtures with magical effects."),
                new Course("Transfiguration", "TR442", "In this class, you will learn the art of changing the form or appearance of an object.")
        );

        List<StudentEntity> studentEntities = new ArrayList<>();
        List<CourseEntity> courseEntities = new ArrayList<>();

        students.forEach(student -> {
            StudentEntity studentEntity = new StudentEntity();
            BeanUtils.copyProperties(student, studentEntity);
            studentEntities.add(studentEntity);

        });

        courses.forEach(course -> {
            CourseEntity courseEntity = new CourseEntity();
            BeanUtils.copyProperties(course, courseEntity);
            courseEntities.add(courseEntity);
        });

        studentRepository.saveAll(studentEntities);
        courseRepository.saveAll(courseEntities);
    }
}
