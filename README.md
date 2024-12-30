
# Proyecto de Recargas en Línea - Backend

## Descripción del Proyecto

Este proyecto consiste en un backend desarrollado en Spring Boot para gestionar la venta de recargas en línea. El sistema permite identificar la cantidad y el valor de las recargas realizadas, discriminadas por operador (Tigo, Movistar, Comcel, Uff) y por vendedor.

### Características principales:
1. Venta de recargas por vendedor.
2. Estadísticas detalladas por operador y vendedor.
3. Registro y visualización del historial de recargas.
4. API RESTful para gestionar operaciones backend.

## Tecnologías Utilizadas

- **Framework**: Spring Boot
- **Lenguaje**: Java
- **Base de datos**: MySql
- **Arquitectura**: Hexagonal

## Estructura del Proyecto

El proyecto sigue una arquitectura hexagonal, organizada de la siguiente manera:

```
src/
└── main/
    └── java/
        └── com/
            └── datacenter/
                └── recargas/
                    ├── application/
                    │   ├── port/
                    │   │   ├── in/
                    │   │   │   ├── operators/
                    │   │   │   ├── sellers/
                    │   │   │   ├── statics/
                    │   │   │   └── topup/
                    │   │   └── out/
                    │   ├── usecase/
                    │       ├── operators/
                    │       ├── sellers/
                    │       ├── statics/
                    │       └── topup/
                    ├── domain/
                    │   └── model/
                    └── infrastructure/
                        ├── adapter/
                        │   ├── database/
                        │   │   ├── entity/
                        │   │   └── repository/
                        │   └── web/
                        │       ├── controller/
                        │       ├── dto/
                        │       └── mapper/
                        └── configuration/
```

### Instrucciones de Configuración

1. Cambiar las credenciales de la base de datos en el archivo `application.properties`:
   ```properties
spring.datasource.url=jdbc:mysql://localhost:3307/recargasdb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
   spring.datasource.username=sa
   spring.datasource.password=
   spring.jpa.hibernate.ddl-auto=update
   ```

2. En resources estan los SQL pero al instalar el proyecto MAVEN y correrlo automaticamente el monta la base de datos, si tienen problemas pueden ejecutarlo tambien de manera manual .

### Instrucciones para Ejecución

1. Clona el repositorio.
2. Navega al directorio `backend`.
3. Ejecuta el siguiente comando para iniciar la aplicación:
   ```bash
   ./mvnw spring-boot:run
   ```
4. La aplicación estará disponible en `http://localhost:9000`.
5. La documentación de la API está disponible en `http://localhost:8080/swagger-ui.html`.

## Diagramas

Los diagramas relacional, de casos de uso, de clases y de secuencia se encuentran disponibles en la raíz del repositorio.

## Requerimientos Cumplidos

1. **Venta de recargas en línea**: API backend implementada.
2. **Estadísticas**: Endpoints para estadísticas por operador y vendedor.
3. **Diagramas**: Se incluyen los diagramas solicitados.
4. **Repositorio Git**: Solución subida a este repositorio.

## Contribuciones


## Autor

Desarrollado por Juan Esteban Londoño.
