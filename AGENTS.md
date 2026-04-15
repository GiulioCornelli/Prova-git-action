# Agent Notes for tutorialjpa

## Build & Run

```bash
./mvnw spring-boot:run        # Run application on port 8090
./mvnw test                   # Run tests
./mvnw package                # Build JAR
```

## Prerequisites

- **PostgreSQL required**: `jdbc:postgresql://localhost:5432/provajpa` (user: `root`, pass: `pippo123`)
- Start Postgres before running the app or tests

## Tech Stack

- Spring Boot 4.0.5, Java 17
- Spring Data JPA, Thymeleaf, Lombok
- Maven with wrapper (use `./mvnw`, not `mvn`)

## Package Structure

```
src/main/java/com/ttf/
  TutorialjpaApplication.java   # Main entry point
  controller/                   # @Controller (Thymeleaf)
  repository/                   # JPA repositories
  service/                      # Business logic
  data/                         # JPA entities (Product.java)
```

## Code Generation

Lombok annotations (`@Data`, `@Getter`, etc.) require annotation processing during compilation. The `pom.xml` configures this correctly; do not remove the `maven-compiler-plugin` annotation processor paths.
