package com.wflin.aiinvestmentplatform.policy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PolicyIndustryRelationMapper {

    private static final List<PolicyIndustryRelation> POLICY_INDUSTRY_RELATIONS =
            Collections.unmodifiableList(Arrays.asList(
                    new PolicyIndustryRelation(1L, 1L, "HIGH", "POSITIVE"),
                    new PolicyIndustryRelation(1L, 4L, "HIGH", "POSITIVE"),
                    new PolicyIndustryRelation(1L, 2L, "MEDIUM", "POSITIVE"),
                    new PolicyIndustryRelation(2L, 2L, "HIGH", "POSITIVE"),
                    new PolicyIndustryRelation(2L, 5L, "HIGH", "POSITIVE"),
                    new PolicyIndustryRelation(3L, 3L, "MEDIUM", "POSITIVE")
            ));

    public List<PolicyIndustryRelation> selectByPolicyId(Long policyId) {
        List<PolicyIndustryRelation> result = new ArrayList<PolicyIndustryRelation>();
        for (PolicyIndustryRelation relation : POLICY_INDUSTRY_RELATIONS) {
            if (relation.getPolicyId().equals(policyId)) {
                result.add(relation);
            }
        }
        return Collections.unmodifiableList(result);
    }
}
