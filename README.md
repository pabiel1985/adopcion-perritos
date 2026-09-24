# Proyecto Java - Sistema de Adopción de Perros

Este proyecto fue desarrollado como trabajo final de Programación II.

## Descripción
El sistema permite gestionar:
- perros disponibles para adopción
- adoptantes
- solicitudes de adopción
- adopciones efectivas
- observaciones del proceso

## Requisitos cumplidos
- Herencia
- Polimorfismo
- Encapsulamiento
- Abstracción
- Clase abstracta
- Interfaz
- Más de 5 clases propias del sistema
- Colecciones
- Excepciones personalizadas
- Clase genérica
- JDBC con base de datos en memoria
- Documentación y código ordenado

## Estructura principal
- `model`: entidades del sistema
- `interfaces`: contrato para animales adoptables
- `exceptions`: manejo de errores específicos
- `genericos`: clase genérica `Repositorio<T>`
- `dao`: acceso a datos con JDBC
- `service`: lógica de negocio
- `ui`: menú principal interactivo

## Ejecución
```bash
mvn clean compile
mvn exec:java
```

## Base de datos
La aplicación usa H2 en memoria y crea las tablas al iniciar la ejecución desde Java, sin depender de un archivo SQL externo.
