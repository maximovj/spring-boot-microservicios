package com.github.maximovj.microservicio_course.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.maximovj.microservicio_course.entities.Course;
import com.github.maximovj.microservicio_course.services.ICourseService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/courses")
@Slf4j
public class CourseController {

    @Autowired
    private ICourseService _Service;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Course course) {
        _Service.save(course);
    }

    @GetMapping("/all")
    public ResponseEntity<?> all() {
        return ResponseEntity.ok(_Service.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> search(@PathVariable Long id) {
        return ResponseEntity.ok(_Service.findById(id));
    }

    @GetMapping("/query/students/{courseId}")
    public ResponseEntity<?> searchCourse(@PathVariable Long courseId) {
        return ResponseEntity.ok(_Service.findStudentByCourseId(courseId));
    }

}
