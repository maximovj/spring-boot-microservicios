package com.github.maximovj.microservicio_student.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.github.maximovj.microservicio_student.entities.Student;
import java.util.List;


@Repository
public interface IStudentRepository  extends JpaRepository<Student, Long> {


    @Query("SELECT s FROM Student s WHERE s.courseId = :courseId")
    List<Student> findAllStudent(Long courseId); 

    //List<Student> findAllByCourseId(Long courseId); 

}
