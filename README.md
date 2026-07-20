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
curl http://localhost:8080/api/industry/list
```

`GET /api/industry/list` returns V1 industry classification data with fields such as `id`, `industryCode`, `industryName`, `level`, `parentId`, `description`, `status`, `createTime`, and `updateTime`.

Optional query parameters:

- `level` - filter by industry hierarchy level.
- `parentId` - filter child industries by parent industry ID.

The legacy `GET /api/industries` endpoint remains available for existing clients.

### Get Industry Detail

```bash
curl http://localhost:8080/api/industry/1
```

`GET /api/industry/{id}` returns a single industry record. Unknown industry IDs return `404 Not Found`.

### List Stocks by Industry

```bash
curl http://localhost:8080/api/industry/1/stocks
```

`GET /api/industry/{id}/stocks` returns related stocks with `stockCode`, `stockName`, and `industryId`.

### Get Industry Score

```bash
curl http://localhost:8080/api/industry/1/score
```

`GET /api/industry/{id}/score` returns five 20-point scoring dimensions: `prosperityScore`, `capitalScore`, `policyScore`, `valuationScore`, and `sentimentScore`, plus computed `totalScore`.

### Get Industry Agent Analysis

```bash
curl http://localhost:8080/api/industry/1/analysis
```

`GET /api/industry/{id}/analysis` returns the structured Industry Agent output: industry basic information, score, related stocks, and an analysis conclusion.

### List Stocks

```bash
curl http://localhost:8080/api/stocks
```

`GET /api/stocks` returns seed stock basic information with fields such as `code`, `name`, `industry`, and `market`.

### Filter Stocks by Industry

```bash
curl "http://localhost:8080/api/stocks?industry=Semiconductors"
```

`GET /api/stocks?industry={industry}` returns stocks for the requested industry. Unknown industries return an empty list.

### Get Stock Detail

```bash
curl http://localhost:8080/api/stocks/300750
```

`GET /api/stocks/{code}` returns stock basic information by stock code. Unknown stock codes return `404 Not Found`.

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
