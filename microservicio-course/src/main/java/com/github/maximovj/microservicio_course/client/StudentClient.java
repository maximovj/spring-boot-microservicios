package com.github.maximovj.microservicio_course.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.github.maximovj.microservicio_course.models.StudentDto;

@FeignClient(
    name = "msvc-student", 
    //url = "localhost:8080/api/v1/students", 
    url = "${student.service.url:localhost:8080/api/v1/students}",
    fallback = StudentClientFallback.class
)
public interface StudentClient {

    @GetMapping("/search/course/{courseId}")
    List<StudentDto> findAllStudentByCourseId(@PathVariable Long courseId);

}