package com.github.maximovj.microservicio_config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

// TODO : Microservicio | APP | COFIG SERVER 
@EnableConfigServer
@SpringBootApplication
public class MicroservicioConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioConfigApplication.class, args);
	}

}
