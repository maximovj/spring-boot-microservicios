package com.github.maximovj.microservicio_student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

// TODO : Microservicio | API | DISCOVERY CLIENT 
@EnableDiscoveryClient
@SpringBootApplication
public class MicroservicioStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioStudentApplication.class, args);
	}

}
