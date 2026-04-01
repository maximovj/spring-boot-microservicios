package com.github.maximovj.microservicio_course.services;

import java.util.List;

import com.github.maximovj.microservicio_course.entities.Course;
import com.github.maximovj.microservicio_course.http.response.StudentByCourseResponse;

public interface ICourseService {

    List<Course> findAll();

    Course findById(Long id);

    void save(Course course);

    StudentByCourseResponse findStudentByCourseId(Long courseId);

}
