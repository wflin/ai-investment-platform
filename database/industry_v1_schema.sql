CREATE TABLE IF NOT EXISTS industry (
    id BIGINT PRIMARY KEY,
    industry_code VARCHAR(64) NOT NULL UNIQUE,
    industry_name VARCHAR(128) NOT NULL,
    level TINYINT NOT NULL,
    parent_id BIGINT NULL,
    description VARCHAR(512) NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',
    create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    INDEX idx_industry_parent_id (parent_id),
    INDEX idx_industry_level (level),
    CONSTRAINT fk_industry_parent FOREIGN KEY (parent_id) REFERENCES industry (id)
);

CREATE TABLE IF NOT EXISTS stock_industry_relation (
    stock_code VARCHAR(16) NOT NULL,
    stock_name VARCHAR(128) NOT NULL,
    industry_id BIGINT NOT NULL,
    PRIMARY KEY (stock_code, industry_id),
    INDEX idx_stock_industry_relation_industry_id (industry_id),
    CONSTRAINT fk_stock_industry_relation_industry
        FOREIGN KEY (industry_id) REFERENCES industry (id)
);

CREATE TABLE IF NOT EXISTS industry_score (
    industry_id BIGINT PRIMARY KEY,
    prosperity_score TINYINT NOT NULL,
    capital_score TINYINT NOT NULL,
    policy_score TINYINT NOT NULL,
    valuation_score TINYINT NOT NULL,
    sentiment_score TINYINT NOT NULL,
    score_date DATE NOT NULL,
    summary VARCHAR(512) NULL,
    create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_industry_score_industry FOREIGN KEY (industry_id) REFERENCES industry (id),
    CONSTRAINT chk_industry_score_prosperity CHECK (prosperity_score BETWEEN 0 AND 20),
    CONSTRAINT chk_industry_score_capital CHECK (capital_score BETWEEN 0 AND 20),
    CONSTRAINT chk_industry_score_policy CHECK (policy_score BETWEEN 0 AND 20),
    CONSTRAINT chk_industry_score_valuation CHECK (valuation_score BETWEEN 0 AND 20),
    CONSTRAINT chk_industry_score_sentiment CHECK (sentiment_score BETWEEN 0 AND 20)
);

INSERT INTO industry (id, industry_code, industry_name, level, parent_id, description, status, create_time, update_time)
VALUES
    (1, 'SW-TECH-SEMIS', 'Semiconductors', 1, NULL, 'Chip design, manufacturing, equipment, and materials.', 'ACTIVE', '2026-01-01 00:00:00', '2026-01-01 00:00:00'),
    (2, 'SW-ENERGY-RENEW', 'Renewable Energy', 1, NULL, 'Solar, wind, storage, and grid infrastructure.', 'ACTIVE', '2026-01-01 00:00:00', '2026-01-01 00:00:00'),
    (3, 'SW-HEALTH-BIO', 'Biopharmaceuticals', 1, NULL, 'Innovative drugs, vaccines, and biotechnology services.', 'ACTIVE', '2026-01-01 00:00:00', '2026-01-01 00:00:00'),
    (4, 'SW-TECH-SEMIS-EQP', 'Semiconductor Equipment', 2, 1, 'Wafer fabrication, packaging, testing, and semiconductor equipment.', 'ACTIVE', '2026-01-01 00:00:00', '2026-01-01 00:00:00'),
    (5, 'SW-ENERGY-SOLAR', 'Solar Equipment', 2, 2, 'Photovoltaic modules, inverters, and production equipment.', 'ACTIVE', '2026-01-01 00:00:00', '2026-01-01 00:00:00')
ON DUPLICATE KEY UPDATE
    industry_name = VALUES(industry_name),
    level = VALUES(level),
    parent_id = VALUES(parent_id),
    description = VALUES(description),
    status = VALUES(status),
    update_time = VALUES(update_time);

INSERT INTO stock_industry_relation (stock_code, stock_name, industry_id)
VALUES
    ('688981', 'Semiconductor Manufacturing International', 1),
    ('002371', 'NAURA Technology Group', 1),
    ('300750', 'Contemporary Amperex Technology', 2),
    ('601012', 'LONGi Green Energy Technology', 2),
    ('600276', 'Jiangsu Hengrui Pharmaceuticals', 3),
    ('300122', 'Chongqing Zhifei Biological Products', 3),
    ('688012', 'Advanced Micro-Fabrication Equipment', 4),
    ('688599', 'Trina Solar', 5)
ON DUPLICATE KEY UPDATE
    stock_name = VALUES(stock_name);

INSERT INTO industry_score (
    industry_id,
    prosperity_score,
    capital_score,
    policy_score,
    valuation_score,
    sentiment_score,
    score_date,
    summary
)
VALUES
    (1, 18, 19, 18, 17, 18, '2026-01-01', 'High demand visibility, active capital support, and constructive policy backdrop.'),
    (2, 17, 16, 18, 16, 17, '2026-01-01', 'Policy support remains strong while valuation pressure requires selectivity.'),
    (3, 15, 15, 16, 15, 15, '2026-01-01', 'Innovation demand is stable, with regulatory and pipeline execution risks.'),
    (4, 17, 18, 17, 16, 17, '2026-01-01', 'Equipment localization supports growth, but order cycles should be monitored.'),
    (5, 15, 15, 17, 14, 15, '2026-01-01', 'Demand is resilient, while industry capacity and margins remain key risks.')
ON DUPLICATE KEY UPDATE
    prosperity_score = VALUES(prosperity_score),
    capital_score = VALUES(capital_score),
    policy_score = VALUES(policy_score),
    valuation_score = VALUES(valuation_score),
    sentiment_score = VALUES(sentiment_score),
    score_date = VALUES(score_date),
    summary = VALUES(summary);
