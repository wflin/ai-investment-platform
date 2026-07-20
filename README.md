# AI Investment Platform

AI Investment Platform is an AI-assisted investment research platform. The current repository includes the first backend REST API for industry analysis.

## Backend

The backend is a Java 8 compatible Spring Boot service located in `backend/`.

### Run Tests

```bash
cd backend
mvn test
```

### Start API

```bash
cd backend
mvn spring-boot:run
```

The service starts on `http://localhost:8080` by default.

### List Industries

```bash
curl http://localhost:8080/api/industries
```

`GET /api/industries` returns seed industry data with fields such as `id`, `name`, `category`, `heatScore`, `prosperityScore`, and `description`.
