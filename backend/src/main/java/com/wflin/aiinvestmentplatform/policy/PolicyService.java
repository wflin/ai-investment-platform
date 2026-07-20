package com.wflin.aiinvestmentplatform.policy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wflin.aiinvestmentplatform.industry.Industry;
import com.wflin.aiinvestmentplatform.industry.IndustryMapper;

@Service
public class PolicyService {

    private final PolicyMapper policyMapper;
    private final PolicyIndustryRelationMapper relationMapper;
    private final IndustryMapper industryMapper;

    public PolicyService() {
        this(new PolicyMapper(), new PolicyIndustryRelationMapper(), new IndustryMapper());
    }

    PolicyService(PolicyMapper policyMapper, PolicyIndustryRelationMapper relationMapper,
            IndustryMapper industryMapper) {
        this.policyMapper = policyMapper;
        this.relationMapper = relationMapper;
        this.industryMapper = industryMapper;
    }

    public List<Policy> findLatest() {
        return policyMapper.selectLatest();
    }

    public Optional<Policy> findById(Long id) {
        return policyMapper.selectById(id);
    }

    public Optional<List<PolicyIndustryImpactDto>> findIndustriesByPolicyId(Long policyId) {
        if (!policyMapper.selectById(policyId).isPresent()) {
            return Optional.empty();
        }

        List<PolicyIndustryImpactDto> impacts = new ArrayList<PolicyIndustryImpactDto>();
        for (PolicyIndustryRelation relation : relationMapper.selectByPolicyId(policyId)) {
            Optional<Industry> industry = industryMapper.selectById(relation.getIndustryId());
            impacts.add(new PolicyIndustryImpactDto(
                    relation.getPolicyId(),
                    relation.getIndustryId(),
                    industry.map(Industry::getIndustryName).orElse(null),
                    relation.getInfluenceLevel(),
                    relation.getInfluenceDirection()));
        }
        return Optional.of(Collections.unmodifiableList(impacts));
    }
}
