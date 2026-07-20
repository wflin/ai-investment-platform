CREATE TABLE IF NOT EXISTS policy (
    id BIGINT PRIMARY KEY,
    title VARCHAR(256) NOT NULL,
    source VARCHAR(128) NOT NULL,
    publish_time DATETIME NOT NULL,
    content TEXT NOT NULL,
    policy_type VARCHAR(64) NOT NULL,
    importance_level VARCHAR(32) NOT NULL,
    create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    INDEX idx_policy_publish_time (publish_time),
    INDEX idx_policy_type (policy_type),
    INDEX idx_policy_importance_level (importance_level)
);

CREATE TABLE IF NOT EXISTS policy_industry_relation (
    policy_id BIGINT NOT NULL,
    industry_id BIGINT NOT NULL,
    influence_level VARCHAR(32) NOT NULL,
    influence_direction VARCHAR(32) NOT NULL,
    PRIMARY KEY (policy_id, industry_id),
    INDEX idx_policy_industry_relation_industry_id (industry_id),
    CONSTRAINT fk_policy_industry_relation_policy
        FOREIGN KEY (policy_id) REFERENCES policy (id),
    CONSTRAINT fk_policy_industry_relation_industry
        FOREIGN KEY (industry_id) REFERENCES industry (id)
);

INSERT INTO policy (
    id,
    title,
    source,
    publish_time,
    content,
    policy_type,
    importance_level,
    create_time,
    update_time
)
VALUES
    (
        1,
        'Strategic AI Computing Infrastructure Action Plan',
        'National Development and Reform Commission',
        '2026-07-15 09:00:00',
        'Policy encourages advanced computing clusters, semiconductor equipment localization, and energy-efficient data centers.',
        'INDUSTRIAL_SUPPORT',
        'HIGH',
        '2026-01-01 00:00:00',
        '2026-01-01 00:00:00'
    ),
    (
        2,
        'Renewable Energy Grid Integration Guidance',
        'National Energy Administration',
        '2026-07-10 10:30:00',
        'Policy promotes renewable generation consumption, energy storage dispatch, and grid investment coordination.',
        'ENERGY_TRANSITION',
        'HIGH',
        '2026-01-01 00:00:00',
        '2026-01-01 00:00:00'
    ),
    (
        3,
        'Biopharmaceutical Innovation Review Measures',
        'National Medical Products Administration',
        '2026-06-25 14:00:00',
        'Policy improves review efficiency for innovative drugs and clarifies post-market monitoring requirements.',
        'REGULATORY_OPTIMIZATION',
        'MEDIUM',
        '2026-01-01 00:00:00',
        '2026-01-01 00:00:00'
    )
ON DUPLICATE KEY UPDATE
    title = VALUES(title),
    source = VALUES(source),
    publish_time = VALUES(publish_time),
    content = VALUES(content),
    policy_type = VALUES(policy_type),
    importance_level = VALUES(importance_level),
    update_time = VALUES(update_time);

INSERT INTO policy_industry_relation (policy_id, industry_id, influence_level, influence_direction)
VALUES
    (1, 1, 'HIGH', 'POSITIVE'),
    (1, 4, 'HIGH', 'POSITIVE'),
    (1, 2, 'MEDIUM', 'POSITIVE'),
    (2, 2, 'HIGH', 'POSITIVE'),
    (2, 5, 'HIGH', 'POSITIVE'),
    (3, 3, 'MEDIUM', 'POSITIVE')
ON DUPLICATE KEY UPDATE
    influence_level = VALUES(influence_level),
    influence_direction = VALUES(influence_direction);
