package com.github.maximovj.microservicio_course.http.response;

import java.util.List;

import com.github.maximovj.microservicio_course.models.StudentDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentByCourseResponse {

    private String courseName;
    private String teacher;
    private List<StudentDto> studentDtoList;
}
