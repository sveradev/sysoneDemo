# 🚗 Sysone Demo — API REST de autos y opcionales

[🇦🇷 Español](#-español) · [🇬🇧 English](#-english)

![Java](https://img.shields.io/badge/Java-8-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.1-6DB33F?logo=springboot&logoColor=white)
![H2](https://img.shields.io/badge/DB-H2-blue)
![Swagger](https://img.shields.io/badge/Docs-Swagger-85EA2D?logo=swagger&logoColor=black)

---

## 🇦🇷 Español

API REST para administrar **autos** y sus **opcionales** (techo corredizo, aire acondicionado, ABS, airbag, llantas de aleación, etc.). Cada auto tiene un precio base y se le pueden asignar opcionales con su propio precio.

### Tecnologías
- **Java 8** + **Spring Boot 2.1** (Spring Web, Spring Data JPA)
- **H2**: base de datos en memoria, no requiere instalación
- **Swagger / Springfox**: documentación interactiva de la API
- Manejo de errores con `@ControllerAdvice` y excepciones propias

### Cómo ejecutarlo
```bash
git clone https://github.com/sveradev/sysoneDemo.git
cd sysoneDemo
./mvnw spring-boot:run        # en Windows: mvnw.cmd spring-boot:run
```
Al iniciar se cargan datos de ejemplo. Después abrí:
- API: `http://localhost:8080/cars`
- Documentación Swagger: `http://localhost:8080/swagger-ui.html`

### Endpoints
| Método | Ruta | Descripción |
|---|---|---|
| GET | `/cars` | Lista todos los autos |
| GET | `/cars/{id}` | Obtiene un auto |
| POST | `/cars` | Crea un auto |
| PUT | `/cars/{id}` | Actualiza un auto |
| DELETE | `/cars/{id}` | Elimina un auto |
| POST | `/cars/{id}/options/{optionId}` | Agrega un opcional a un auto |
| GET | `/options` | Lista los opcionales |
| GET | `/options/{optionId}` | Obtiene un opcional |
| POST | `/options` | Crea un opcional |
| PUT | `/options/{id}` | Actualiza un opcional |
| DELETE | `/options/{id}` | Elimina un opcional |

### Estructura
```
src/main/java/com/sysone/demo
├── controller/   # Endpoints REST
├── model/        # Entidades JPA (Car, Option)
├── repository/   # Repositorios Spring Data + carga inicial
└── exceptions/   # Excepciones y manejo de errores
```

---

## 🇬🇧 English

REST API to manage **cars** and their **optional extras** (sunroof, air conditioning, ABS, airbags, alloy wheels, etc.). Each car has a base price, and options with their own price can be added to it.

### Tech stack
- **Java 8** + **Spring Boot 2.1** (Spring Web, Spring Data JPA)
- **H2** in-memory database, no setup needed
- **Swagger / Springfox** for interactive API docs
- Error handling with `@ControllerAdvice` and custom exceptions

### Running it
```bash
git clone https://github.com/sveradev/sysoneDemo.git
cd sysoneDemo
./mvnw spring-boot:run        # on Windows: mvnw.cmd spring-boot:run
```
Sample data is loaded on startup. Then open:
- API: `http://localhost:8080/cars`
- Swagger docs: `http://localhost:8080/swagger-ui.html`

The endpoint table and project structure above apply to both languages.

---

👤 **Sebastián Ariel Vera** · [LinkedIn](https://www.linkedin.com/in/sebastian-ariel-vera-9b240735)
