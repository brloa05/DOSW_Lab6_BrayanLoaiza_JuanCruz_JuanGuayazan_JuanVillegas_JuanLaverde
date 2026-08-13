# Laboratorio 7: TDD, cubrimiento y análisis estático

Aplicación de TDD sobre un sistema de gestión de bibliotecas, con medición de cobertura (JaCoCo) y análisis estático de código (SonarQube).

## Autores

BRAYAN LOAIZA LEAL, JUAN ESTEBAN CRUZ RICO, JUAN JOSÉ LAVERDE RÍOS, JUAN MANUEL VILLEGAS MEDINA y JUAN SEBASTIÁN GUAYAZÁN CLAVIJO
Desarrollo y Operaciones Software (ISIS DOSW-301)
Decanatura Ingeniería de Sistemas
Ingeniería de Sistemas
Escuela Colombiana de Ingeniería Julio Garavito
2026-1

## Estructura del proyecto

```
DOSW_Lab6_BrayanLoaiza_JuanCruz_JuanGuayazan_JuanVillegas_JuanLaverde/
├── pom.xml
├── src/
│   ├── main/java/edu/eci/dosw/tdd/
│   │   ├── App.java
│   │   └── library/
│   │       ├── Library.java
│   │       ├── book/Book.java
│   │       ├── loan/Loan.java
│   │       ├── loan/LoanStatus.java
│   │       └── user/User.java
│   └── test/java/edu/eci/dosw/tdd/
│       ├── AppTest.java
│       └── library/LibraryTest.java
└── image.png
```

## Cómo ejecutar

```bash
mvn test
mvn verify   # ejecuta pruebas + genera reporte de cobertura JaCoCo
```

## Contexto y conceptos clave

### Resumen del laboratorio

Aplicación de TDD como fundamento de estructuración técnica, sobre un sistema de gestión de bibliotecas (`edu.eci.dosw.tdd`) con las clases `Book`, `User`, `Loan`/`LoanStatus` y `Library`. El laboratorio tuvo dos partes:

1. **Proyecto Biblioteca (TDD, cobertura y análisis estático)**:
   - Configuración de JUnit 5 en el `pom.xml` y creación de los paquetes `library`, `book`, `loan` y `user`.
   - Implementación por TDD (prueba antes que código, un caso por integrante) de los métodos `addBook`, `loanABook` y `returnLoan` de la clase `Library`, validando reglas como disponibilidad del libro, existencia del usuario y no duplicidad de préstamos activos.
   - Integración de **JaCoCo** para medir cobertura de pruebas, con un mínimo exigido del 80-85% por paquete.
   - Análisis estático de código con **SonarQube** (contenedor Docker), integrado a Maven vía `sonar-maven-plugin` y el reporte de JaCoCo.
   - Cada paso se desarrolló en ramas `feature/*` independientes, integradas a `develop` mediante Pull Requests revisados por un integrante distinto de quien los creó.
2. **Proyecto del curso**: diagrama de clases y esqueletos TDD para las historias de usuario del primer sprint del proyecto TechCup Fútbol.

### Conceptos clave

- TDD (Test-Driven Development): prueba antes que código
- JUnit 5 para pruebas unitarias
- JaCoCo para cobertura de pruebas
- SonarQube para análisis estático de calidad de código
- Flujo de ramas `feature/*` con revisión por pares (Pull Requests)

### Resultados

Los métodos `addBook`, `loanABook` y `returnLoan` de `Library` quedan implementados y validados por TDD, con cobertura de pruebas medida por paquete y análisis estático de calidad verificado en SonarQube.
