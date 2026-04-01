package com.github.maximovj.microservicio_course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.maximovj.microservicio_course.entities.Course;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Long> {

    

}
