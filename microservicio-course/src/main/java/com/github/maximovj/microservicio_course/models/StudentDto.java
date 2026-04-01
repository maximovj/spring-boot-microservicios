package com.github.maximovj.microservicio_course.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private Long id;

    private String name;
    
    private String lastname;
    
    private String email;
    
    private Long courseId;

}
