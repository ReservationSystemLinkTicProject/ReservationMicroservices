# Spring Boot Microservices Project

Este es un proyecto de backend basado en Spring Boot que utiliza una arquitectura de microservicios. El proyecto incluye un API Gateway, Config Server, Eureka para el descubrimiento de servicios, y dos microservicios: `users`,  `servicios` y `reservations`.

## Requisitos

Antes de empezar, asegúrate de tener las siguientes herramientas instaladas en tu máquina:

- **Java JDK 22 o superior**: [Descargar Java](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- **Maven**: [Descargar Maven](https://maven.apache.org/download.cgi)

## Estructura del Proyecto
![image](https://github.com/user-attachments/assets/46563d3c-921e-4416-9e1e-4cf1831a048b)

El proyecto está estructurado en varios módulos:

- **api-gateway**: Gateway API que enruta las solicitudes a los microservicios correspondientes.
- **config-server**: Servidor de configuración que proporciona configuración centralizada a los microservicios.
- **eureka-server**: Servidor de descubrimiento de servicios.
- **services**: Servicio principal que gestiona la lógica de negocio relacionada con los usuarios.
- **reservations**: Servicio principal que gestiona la lógica de negocio relacionada con las reservas.
- **users**: Servicio principal que gestiona la lógica de negocio relacionada con los usuarios.

## Configuración

### 1. Config Server

El Config Server proporciona la configuración centralizada para todos los microservicios. 

### 2. Eureka Server

Eureka Server es el servidor de descubrimiento de servicios. 

### 3. API Gateway

El API Gateway enruta las solicitudes a los microservicios apropiados basándose en la configuración de rutas.

### 4. Servicios

Cada servicio (`users`, `reservations`, etc.) debe estar configurado para registrar su instancia en el Eureka Server y obtener su configuración del Config Server.

## Instalación y Ejecución

Sigue estos pasos para ejecutar el proyecto:

1. **Clonar el Repositorio**

   Clona el repositorio en tu máquina local:

   ```
   https://github.com/ReservationSystemLinkTicProject/ReservationMicroservices.git
 

Navegar al Directorio del Proyecto

 ```
cd ReservationMicroservices
 ```
Compilar y Ejecutar los Servicios

Navega a cada subdirectorio de los servicios (api-gateway, config-server, eureka-server, users, reservations) y ejecuta el siguiente comando:
 ```
mvn spring-boot:run
 ```

#### se recomienda el siguiente order

* config server
* eureka
* api-gateway
* los otros microservicios

Todos deben estar levantados

Alternativamente, puedes construir y ejecutar todos los servicios juntos con:

 ```
mvn clean install
 ```

Verificar el Funcionamiento

Eureka Server estará disponible en http://localhost:8761.
Config Server estará disponible en http://localhost:8888.
API Gateway estará disponible en http://localhost:8080.
Servicios (users, reservations, resevation) estarán disponibles en http://localhost:8090, http://localhost:8091 y http://localhost:8092 respectivamente si se agrega */swagger-ui/index.html* alas rutas anteriores podra encontra una documentacion basica de los endpoints.
Rutas del API Gateway
El API Gateway enruta las solicitudes a los siguientes servicios:

/api/users/** se enruta a users
/api/reservations/** se enruta a reservations
/api/services/** se enruta a services


Licencia
Este proyecto está licenciado bajo la Licencia MIT.
