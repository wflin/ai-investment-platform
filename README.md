# AI Investment Platform

AI Investment Platform is an AI-assisted investment research platform. The current repository includes backend REST APIs for industry analysis and issue detail lookup.

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

### Get Issue Detail

```bash
curl http://localhost:8080/api/issues/17
```

`GET /api/issues/{id}` returns seed issue detail data with fields such as `id`, `title`, `status`, `priority`, `summary`, and `description`. Unknown issue IDs return `404 Not Found`.

AI Investment Platform is a scaffold for an AI-assisted investment research platform.

## Repository Layout

- `backend/` - Spring Boot backend module placeholder
- `frontend/` - frontend module placeholder
- `ai-agent/` - AI agent layer placeholder
- `data-center/` - market and fundamentals data layer placeholder
- `database/` - schema and migration assets
- `deployment/` - deployment assets
- `scripts/` - utility scripts

## Documentation

- [AI_RULES.md](AI_RULES.md)
- [CODEX_GUIDE.md](CODEX_GUIDE.md)
- [docs/PRD.md](docs/PRD.md)
- [docs/ARCHITECTURE.md](docs/ARCHITECTURE.md)
- [docs/AI_AGENT_DESIGN.md](docs/AI_AGENT_DESIGN.md)

## Current Status

The repository contains documentation, module scaffolding, and initial Spring Boot backend REST APIs.

## Auto Merge Test

This change is created for GitHub auto-merge testing.
