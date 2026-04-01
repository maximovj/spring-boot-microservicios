package com.github.maximovj.microservicio_student.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.maximovj.microservicio_student.entities.Student;
import com.github.maximovj.microservicio_student.repositories.IStudentRepository;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentRepository _repository;

    @Override
    public List<Student> findAll() {
        return (List<Student>) _repository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return _repository.findById(id).orElseThrow();
    }

    @Override
    public void save(Student student) {
        _repository.save(student);
    }

    @Override
    public List<Student> findByIdCourse(Long courseId) {
        return _repository.findAllStudent(courseId);
    }

}
