package com.github.maximovj.microservicio_course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.maximovj.microservicio_course.client.StudentClient;
import com.github.maximovj.microservicio_course.entities.Course;
import com.github.maximovj.microservicio_course.http.response.StudentByCourseResponse;
import com.github.maximovj.microservicio_course.models.StudentDto;
import com.github.maximovj.microservicio_course.repositories.ICourseRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CourseServiceImpl implements ICourseService {

    private final String SERVICE_NAME = "courseServiceImpl"; 

    @Autowired
    private ICourseRepository _repository;

    @Autowired
    private StudentClient _Client;

    @Override
    public List<Course> findAll() {
        return _repository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return _repository.findById(id).orElseThrow();
    }

    @Override
    public void save(Course course) {
        _repository.save(course);
    }

    @Override
    public StudentByCourseResponse findStudentByCourseId(Long courseId) {
        // Consultar Curso
         Course course = _repository.findById(courseId)
            .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        // Obtener los estudiantes
        List<StudentDto> studentDtoList = _Client.findAllStudentByCourseId(courseId);
        
        return StudentByCourseResponse.builder()
        .courseName(course.getName())
        .teacher(course.getTeacher())
        .studentDtoList(studentDtoList)
        .build();
    }
    
}
