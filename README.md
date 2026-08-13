# Laboratorio 7: TDD, cubrimiento y análisis estático

* BRAYAN LOAIZA LEAL​
* JUAN ESTEBAN CRUZ RICO​
* JUAN JOSÉ LAVERDE RÍOS
* JUAN MANUEL VILLEGAS MEDINA
* JUAN SEBASTIÁN GUAYAZÁN CLAVIJO

Desarrollo y Operaciones Software (ISIS DOSW-301)     
Decanatura Ingeniería de Sistemas     
Ingeniería de Sistemas    
Escuela Colombiana de Ingeniería Julio Garavito     
2026-1    ​

## Contexto del laboratorio

Aplicación de TDD como fundamento de estructuración técnica, sobre un sistema de gestión de bibliotecas (`edu.eci.dosw.tdd`) con las clases `Book`, `User`, `Loan`/`LoanStatus` y `Library`. El laboratorio tuvo dos partes:

1. **Proyecto Biblioteca (TDD, cobertura y análisis estático)**:
   - Configuración de JUnit 5 en el `pom.xml` y creación de los paquetes `library`, `book`, `loan` y `user`.
   - Implementación por TDD (prueba antes que código, un caso por integrante) de los métodos `addBook`, `loanABook` y `returnLoan` de la clase `Library`, validando reglas como disponibilidad del libro, existencia del usuario y no duplicidad de préstamos activos.
   - Integración de **JaCoCo** para medir cobertura de pruebas, con un mínimo exigido del 80-85% por paquete.
   - Análisis estático de código con **SonarQube** (contenedor Docker), integrado a Maven vía `sonar-maven-plugin` y el reporte de JaCoCo.
   - Cada paso se desarrolló en ramas `feature/*` independientes, integradas a `develop` mediante Pull Requests revisados por un integrante distinto de quien los creó.
2. **Proyecto del curso**: diagrama de clases y esqueletos TDD para las historias de usuario del primer sprint del proyecto TechCup Fútbol.
