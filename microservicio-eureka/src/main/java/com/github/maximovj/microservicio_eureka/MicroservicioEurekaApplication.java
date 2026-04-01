package com.github.maximovj.microservicio_eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

// TODO : Microservicio | APP | EUREKA SERVER
@EnableEurekaServer
@SpringBootApplication
public class MicroservicioEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioEurekaApplication.class, args);
	}

}
