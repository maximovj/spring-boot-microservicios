package com.github.maximovj.microservicio_course.client;

import java.util.List;

import org.springframework.stereotype.Component;

import com.github.maximovj.microservicio_course.models.StudentDto;

import lombok.extern.slf4j.Slf4j;

// Clase de fallback
@Component
@Slf4j
class StudentClientFallback implements StudentClient {
    
    @Override
    public List<StudentDto> findAllStudentByCourseId(Long courseId) {
        log.warn("Fallback activado para findAllStudentByCourseId con courseId: {}", courseId);
        
        // Retornar lista vacía o datos por defecto
        return List.of(
            StudentDto.builder()
                .id(0L)
                .name("Temporal")
                .lastname("Student")
                .email("temp@example.com")
                .courseId(courseId)
                .build()
        );
    }
}