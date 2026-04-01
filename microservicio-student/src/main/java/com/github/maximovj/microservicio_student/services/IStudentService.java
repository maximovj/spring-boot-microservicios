package com.github.maximovj.microservicio_student.services;

import java.util.List;

import com.github.maximovj.microservicio_student.entities.Student;

public interface IStudentService {

    List<Student> findAll();

    Student findById(Long id);

    void save(Student student);

    List<Student> findByIdCourse(Long courseId);

}
