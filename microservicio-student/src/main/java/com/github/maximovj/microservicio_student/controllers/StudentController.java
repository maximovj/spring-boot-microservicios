package com.github.maximovj.microservicio_student.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.maximovj.microservicio_student.entities.Student;
import com.github.maximovj.microservicio_student.services.IStudentService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/students")
@Slf4j
public class StudentController {

    @Autowired
    private IStudentService _service;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody Student student) {
        _service.save(student);
    }

    @GetMapping("/all")
    public ResponseEntity<?> searchs() {
        return ResponseEntity.ok(_service.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> search(@PathVariable Long id) {
        return ResponseEntity.ok(_service.findById(id));
    }

    @GetMapping("/search/course/{courseId}")
    public ResponseEntity<?> findByIdCourse(@PathVariable Long courseId) {
        return ResponseEntity.ok(_service.findByIdCourse(courseId));
    }

}
