# AI Agent Design

## V1 Industry Agent Contract

Input:
- `industryId`

Output:
- `industry` - industry basic information.
- `score` - five-dimension industry score and computed total score.
- `stocks` - stock and industry relation list.
- `conclusion` - deterministic analysis summary for the current seed data.

Backend endpoint:
- `GET /api/industry/{id}/analysis`

The current backend implementation is seed-backed and uses mapper-style classes so the data access layer can later be replaced with MyBatis/MySQL without changing the API contract.

## V1 Policy Agent Contract

Input:
- `policyId`

Output:
- `policy` - policy title, source, publish time, content, type, and importance.
- `industries` - related industry impact list with influence level and direction.
- `summary` - deterministic policy impact summary for the current seed data.
- `opportunity` - positive industry catalyst summary.
- `risk` - implementation and demand pull-through risk reminder.
- `recommendation` - next research action for affected industries.

Backend endpoint:
- `GET /api/policies/{id}/analysis`

Policy data endpoints:
- `GET /api/policies/latest`
- `GET /api/policies/{id}`
- `GET /api/policies/{id}/industries`

## Investment Director Agent

负责统筹投资研究流程。

## Industry Agent

职责：
- 行业趋势分析
- 行业评分
- 板块轮动

## Stock Agent

职责：
- 公司基本面分析
- 财务指标分析
- 估值分析

## News Agent

职责：
- 新闻采集
- 情绪判断
- 影响分析

## Report Agent

职责：
- 生成投资研究报告

## Risk Agent

职责：
- 风险提示
- 仓位建议
