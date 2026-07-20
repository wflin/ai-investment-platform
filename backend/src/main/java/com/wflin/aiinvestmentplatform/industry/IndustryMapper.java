package com.wflin.aiinvestmentplatform.industry;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class IndustryMapper {

    private static final LocalDateTime SEED_TIME = LocalDateTime.of(2026, 1, 1, 0, 0);
    private static final Map<Long, Industry> INDUSTRIES_BY_ID = createIndustriesById();

    public List<Industry> selectAll() {
        return Collections.unmodifiableList(new ArrayList<Industry>(INDUSTRIES_BY_ID.values()));
    }

    public Optional<Industry> selectById(Long id) {
        return Optional.ofNullable(INDUSTRIES_BY_ID.get(id));
    }

    private static Map<Long, Industry> createIndustriesById() {
        List<Industry> industries = Arrays.asList(
                new Industry(1L, "SW-TECH-SEMIS", "Semiconductors", 1, null,
                        "Chip design, manufacturing, equipment, and materials.", "ACTIVE", SEED_TIME, SEED_TIME),
                new Industry(2L, "SW-ENERGY-RENEW", "Renewable Energy", 1, null,
                        "Solar, wind, storage, and grid infrastructure.", "ACTIVE", SEED_TIME, SEED_TIME),
                new Industry(3L, "SW-HEALTH-BIO", "Biopharmaceuticals", 1, null,
                        "Innovative drugs, vaccines, and biotechnology services.", "ACTIVE", SEED_TIME, SEED_TIME),
                new Industry(4L, "SW-TECH-SEMIS-EQP", "Semiconductor Equipment", 2, 1L,
                        "Wafer fabrication, packaging, testing, and semiconductor equipment.", "ACTIVE", SEED_TIME,
                        SEED_TIME),
                new Industry(5L, "SW-ENERGY-SOLAR", "Solar Equipment", 2, 2L,
                        "Photovoltaic modules, inverters, and production equipment.", "ACTIVE", SEED_TIME, SEED_TIME)
        );

        Map<Long, Industry> industriesById = new LinkedHashMap<Long, Industry>();
        for (Industry industry : industries) {
            industriesById.put(industry.getId(), industry);
        }
        return Collections.unmodifiableMap(industriesById);
    }
}
