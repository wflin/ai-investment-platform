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

The repository contains documentation and empty module scaffolding only.
