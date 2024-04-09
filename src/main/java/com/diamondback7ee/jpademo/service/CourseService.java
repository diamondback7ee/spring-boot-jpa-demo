package com.diamondback7ee.jpademo.service;

import com.diamondback7ee.jpademo.entity.CourseEntity;
import com.diamondback7ee.jpademo.model.Course;
import com.diamondback7ee.jpademo.repository.CourseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;
    public Course getCourse(Long id) {
        CourseEntity courseEntity = courseRepository.findById(id).get();
        Course course = new Course();
        BeanUtils.copyProperties(courseEntity, course);
        return course;
    }

    public Course saveCourse(Course course) {
        CourseEntity courseEntity = new CourseEntity();
        BeanUtils.copyProperties(course, courseEntity);
        courseRepository.save(courseEntity);
        return course;
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    public List<Course> getCourses() {
        Iterable<CourseEntity> courseEntities = courseRepository.findAll();

        List<Course> courses = new ArrayList<>();
        courseEntities.forEach(courseEntity -> {
            Course course = new Course();
            BeanUtils.copyProperties(courseEntity, course);
            courses.add(course);
        });

        return courses;
    };
}
