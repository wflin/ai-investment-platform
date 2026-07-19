# System Architecture

## Overall Architecture

User
 |
Frontend
 |
Backend API
 |
AI Agent Layer
 |
Data Layer

## Modules

### Backend

负责：
- 用户管理
- 股票数据管理
- 投资组合
- API服务

### AI Agent

包括：

- Industry Agent
  行业分析

- Stock Agent
  个股研究

- News Agent
  新闻分析

- Report Agent
  投研报告生成

- Risk Agent
  风险分析

### Data Center

数据来源：

- 行情数据
- 财报数据
- 新闻公告
- 行业数据

## AI技术

LLM + RAG + Agent

## Deployment

Docker + Linux + CI/CD
