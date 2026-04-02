package com.github.maximovj.microservicio_course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.maximovj.microservicio_course.client.StudentClient;
import com.github.maximovj.microservicio_course.entities.Course;
import com.github.maximovj.microservicio_course.http.response.StudentByCourseResponse;
import com.github.maximovj.microservicio_course.models.StudentDto;
import com.github.maximovj.microservicio_course.repositories.ICourseRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CourseServiceImpl implements ICourseService {
    
    @Autowired
    private ICourseRepository _repository;
    
    @Autowired
    private StudentClient _Client;

    private final String SERVICE_NAME = "courseService"; 
    
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
    @CircuitBreaker(name = SERVICE_NAME, fallbackMethod = "findStudentByCourseIdFallback")
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

    // métod para fallbackMethod
    public StudentByCourseResponse findStudentByCourseIdFallback(Long courseId, Exception e) {
        log.warn("⚠️ Circuit Breaker ACTIVADO para courseId: {}. Error: {}", courseId, e.getMessage());
        
        // Consultar Curso (operación local que no debería fallar)
        Course course = _repository.findById(courseId).orElse(null);
        
        // Si el curso no existe, retornar respuesta por defecto
        if (course == null) {
            log.error("Curso no encontrado para fallback con ID: {}", courseId);
            return StudentByCourseResponse.builder()
                .courseName("Curso no disponible")
                .teacher("Profesor no disponible")
                .studentDtoList(List.of(new StudentDto(0L, "user-temp", "user-temp", "user-temp", courseId)))
                .build();
        }
        
        return StudentByCourseResponse.builder()
            .courseName(course.getName())
            .teacher(course.getTeacher())
            .studentDtoList(List.of(new StudentDto(0L, "user-temp", "user-temp", "user-temp", courseId)))
            .build();
    }
    
}
