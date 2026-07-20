package com.wflin.aiinvestmentplatform.industry;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class IndustryScoreMapper {

    private static final Map<Long, IndustryScore> SCORES_BY_INDUSTRY_ID = createScoresByIndustryId();

    public Optional<IndustryScore> selectByIndustryId(Long industryId) {
        return Optional.ofNullable(SCORES_BY_INDUSTRY_ID.get(industryId));
    }

    private static Map<Long, IndustryScore> createScoresByIndustryId() {
        LocalDate scoreDate = LocalDate.of(2026, 1, 1);
        List<IndustryScore> scores = Arrays.asList(
                new IndustryScore(1L, 18, 19, 18, 17, 18, scoreDate,
                        "High demand visibility, active capital support, and constructive policy backdrop."),
                new IndustryScore(2L, 17, 16, 18, 16, 17, scoreDate,
                        "Policy support remains strong while valuation pressure requires selectivity."),
                new IndustryScore(3L, 15, 15, 16, 15, 15, scoreDate,
                        "Innovation demand is stable, with regulatory and pipeline execution risks."),
                new IndustryScore(4L, 17, 18, 17, 16, 17, scoreDate,
                        "Equipment localization supports growth, but order cycles should be monitored."),
                new IndustryScore(5L, 15, 15, 17, 14, 15, scoreDate,
                        "Demand is resilient, while industry capacity and margins remain key risks.")
        );

        Map<Long, IndustryScore> scoresByIndustryId = new LinkedHashMap<Long, IndustryScore>();
        for (IndustryScore score : scores) {
            scoresByIndustryId.put(score.getIndustryId(), score);
        }
        return Collections.unmodifiableMap(scoresByIndustryId);
    }
}
