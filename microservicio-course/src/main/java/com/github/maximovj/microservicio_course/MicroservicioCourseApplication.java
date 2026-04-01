package com.github.maximovj.microservicio_course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

// TODO : Microservicio | API | DISCOVERY CLIENT
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class MicroservicioCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioCourseApplication.class, args);
	}

}
