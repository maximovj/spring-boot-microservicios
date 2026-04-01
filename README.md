# Microservicios con SpringBoot + MySQL + PostreSQL

Este repositorio contiene una práctica de microservicios

Se usa Maven + SpringBoot + MySQL + PostgreSQL, etc.

## Estructura del proyecto

| Microservicio | Descripción | Puerto |
|--------------|-------------|--------|
| **microservicio-config** | Servidor de configuración centralizada con Spring Cloud Config | 8888 |
| **microservicio-eureka** | Service Registry con Netflix Eureka | 8761 |
| **microservicio-gateway** | API Gateway con Spring Cloud Gateway | 8080 |
| **microservicio-student** | Gestión de estudiantes y sus datos | 8090 / 8080 |
| **microservicio-course** | Gestión de cursos y asignaciones | 9090 / 8080 |

## Tecnologías
- Spring Boot 3.x
- Spring Cloud
- Maven/Gradle
- Docker

## Configuración local
1. Clonar el repositorio
2. Configurar variables de entorno en `application-local.yml`
3. Ejecutar con `./mvnw spring-boot:run`

## 📊 Resumen de lo logrado

| Componente | Stack | Estado |
|------------|-------|--------|
| **Config Server** | ![Spring Cloud](https://img.shields.io/badge/Spring_Cloud-Config-6DB33F) | ✅ Funcionando |
| **Eureka Server** | ![Netflix](https://img.shields.io/badge/Netflix-Eureka-FF0000) | ✅ Registrando servicios |
| **Student Service** | ![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F) ![MySQL](https://img.shields.io/badge/MySQL-8.0-4479A1) | ✅ CRUD operativo |
| **Course Service** | ![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F) ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-336791) | ✅ CRUD operativo |
| **API Gateway** | ![Spring Cloud](https://img.shields.io/badge/Spring_Cloud-Gateway-6DB33F) | ✅ Rutas configuradas |
| **Feign Clients** | ![OpenFeign](https://img.shields.io/badge/OpenFeign-Client-6DB33F) | ✅ Comunicación exitosa |
| **Actuator** | ![Spring Boot](https://img.shields.io/badge/Actuator-Monitoring-6DB33F) | ✅ Health checks disponibles |

## Arquitectura funcionando:
```
Cliente → Gateway (8080) → Servicios (Student:8090, Course:9090) → Eureka (8761)
                              ↓
                        Config Server (8888)
```

# Vista Previa

![preview_01.png](/screenshots/preview_01.png)

![preview_02.png](/screenshots/preview_02.png)

![preview_03.png](/screenshots/preview_03.png)