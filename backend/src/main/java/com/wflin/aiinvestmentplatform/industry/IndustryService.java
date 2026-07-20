package com.wflin.aiinvestmentplatform.industry;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class IndustryService {

    private static final List<Industry> INDUSTRIES = Collections.unmodifiableList(Arrays.asList(
            new Industry(1L, "Semiconductors", "Technology", 92, 88,
                    "Chip design, manufacturing, equipment, and materials."),
            new Industry(2L, "Renewable Energy", "Energy", 84, 81,
                    "Solar, wind, storage, and grid infrastructure."),
            new Industry(3L, "Biopharmaceuticals", "Healthcare", 78, 76,
                    "Innovative drugs, vaccines, and biotechnology services.")
    ));

    public List<Industry> findAll() {
        return INDUSTRIES;
    }
}
