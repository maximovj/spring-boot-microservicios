package com.github.maximovj.microservicio_course.client;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import com.github.maximovj.microservicio_course.models.StudentDto;

@Slf4j
@Component
public class StudentClientFallbackFactory implements FallbackFactory<StudentClient> {
    
    @Override
    public StudentClient create(Throwable cause) {
        return new StudentClient() {
            @Override
            public List<StudentDto> findAllStudentByCourseId(Long courseId) {
                log.error("Fallback activado para courseId: {}, Error: {}", courseId, cause.getMessage());
                
                // Puedes manejar diferentes tipos de errores
                if (cause instanceof RuntimeException) {
                    log.error("Error de ejecución: {}", cause.getMessage());
                }
                
                return List.of(
                    StudentDto.builder()
                        .id(0L)
                        .name("Fallback")
                        .lastname("Student")
                        .email("fallback@example.com")
                        .courseId(courseId)
                        .build()
                );
            }
        };
    }
}