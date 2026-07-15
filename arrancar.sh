#!/bin/bash

# Función para arrancar un servicio, mandarlo a segundo plano y esperar
arrancar_y_esperar() {
    echo "===================================================="
    echo "🚀 Iniciando: $1"
    echo "===================================================="
    
    # Entramos a la carpeta del microservicio
    cd "$1" || exit
    
    # Ejecutamos en segundo plano (&) y redirigimos la salida a un log 
    # para que no ensucie la terminal principal
    mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Xmx128m" > tu_log_$(basename "$1").log 2>&1 &
    
    # Regresamos a la carpeta raíz
    cd ..
    
    echo "⏱️  Servicio $1 enviado a segundo plano."
    echo "⏳ Esperando 3 minutos (180 segundos) antes del siguiente..."
    sleep 180
}

# --- FLUJO DE ARRANQUE ---
# Ajusta los nombres de las carpetas según tu proyecto exacto

# 1. Primero el Servidor de Configuración (si depende de él)
arrancar_y_esperar "microservicio-config"

# 2. El servidor Eureka
arrancar_y_esperar "microservicio-eureka"

# 3. El Gateway
arrancar_y_esperar "microservicio-gateway"

# 4. Tus microservicios de lógica de negocio
arrancar_y_esperar "microservicio-course"
arrancar_y_esperar "microservicio-student"

echo "===================================================="
echo "🎉 ¡Todos los servicios han sido lanzados!"
echo "===================================================="