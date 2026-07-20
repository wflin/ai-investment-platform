package com.wflin.aiinvestmentplatform.industry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class IndustryService {

    private final IndustryMapper industryMapper;
    private final IndustryStockRelationMapper stockRelationMapper;
    private final IndustryScoreMapper scoreMapper;
    private final IndustryAgent industryAgent;

    public IndustryService() {
        this(new IndustryMapper(), new IndustryStockRelationMapper(), new IndustryScoreMapper(), new IndustryAgent());
    }

    IndustryService(IndustryMapper industryMapper, IndustryStockRelationMapper stockRelationMapper,
            IndustryScoreMapper scoreMapper, IndustryAgent industryAgent) {
        this.industryMapper = industryMapper;
        this.stockRelationMapper = stockRelationMapper;
        this.scoreMapper = scoreMapper;
        this.industryAgent = industryAgent;
    }

    public List<Industry> findAll() {
        return industryMapper.selectAll();
    }

    public List<Industry> findAll(Integer level, Long parentId) {
        if (level == null && parentId == null) {
            return findAll();
        }

        List<Industry> filteredIndustries = new ArrayList<Industry>();
        for (Industry industry : industryMapper.selectAll()) {
            boolean levelMatches = level == null || level.equals(industry.getLevel());
            boolean parentMatches = parentId == null || parentId.equals(industry.getParentId());
            if (levelMatches && parentMatches) {
                filteredIndustries.add(industry);
            }
        }
        return Collections.unmodifiableList(filteredIndustries);
    }

    public Optional<Industry> findById(Long id) {
        return industryMapper.selectById(id);
    }

    public Optional<List<IndustryStockRelation>> findStocksByIndustryId(Long industryId) {
        if (!industryMapper.selectById(industryId).isPresent()) {
            return Optional.empty();
        }
        return Optional.of(stockRelationMapper.selectByIndustryId(industryId));
    }

    public Optional<IndustryScore> findScoreByIndustryId(Long industryId) {
        if (!industryMapper.selectById(industryId).isPresent()) {
            return Optional.empty();
        }
        return scoreMapper.selectByIndustryId(industryId);
    }

    public Optional<IndustryAgentReport> analyzeIndustry(Long industryId) {
        Optional<Industry> industry = industryMapper.selectById(industryId);
        Optional<IndustryScore> score = scoreMapper.selectByIndustryId(industryId);
        if (!industry.isPresent() || !score.isPresent()) {
            return Optional.empty();
        }
        List<IndustryStockRelation> stocks = stockRelationMapper.selectByIndustryId(industryId);
        return Optional.of(industryAgent.analyze(industry.get(), score.get(), stocks));
    }

    public List<IndustryLegacySummary> findLegacySummaries() {
        return Collections.unmodifiableList(Arrays.asList(
                new IndustryLegacySummary(1L, "Semiconductors", "Technology", 92, 88,
                        "Chip design, manufacturing, equipment, and materials."),
                new IndustryLegacySummary(2L, "Renewable Energy", "Energy", 84, 81,
                        "Solar, wind, storage, and grid infrastructure."),
                new IndustryLegacySummary(3L, "Biopharmaceuticals", "Healthcare", 78, 76,
                        "Innovative drugs, vaccines, and biotechnology services.")
        ));
    }
}
