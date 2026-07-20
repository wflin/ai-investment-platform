package com.wflin.aiinvestmentplatform.policy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.wflin.aiinvestmentplatform.industry.IndustryMapper;

class PolicyAnalysisServiceTest {

    private final PolicyService policyService = new PolicyService(new PolicyMapper(),
            new PolicyIndustryRelationMapper(), new IndustryMapper());
    private final PolicyAnalysisService policyAnalysisService = new PolicyAnalysisService(policyService);

    @Test
    void analyzePolicyBuildsDeterministicPolicyAgentReport() {
        Optional<PolicyAnalysisReportDto> report = policyAnalysisService.analyzePolicy(1L);

        assertThat(report).isPresent();
        assertThat(report.get().getPolicy().getTitle())
                .isEqualTo("Strategic AI Computing Infrastructure Action Plan");
        assertThat(report.get().getIndustries()).hasSize(3);
        assertThat(report.get().getSummary())
                .isEqualTo("Strategic AI Computing Infrastructure Action Plan from National Development and Reform Commission is a HIGH importance INDUSTRIAL_SUPPORT policy affecting 3 tracked industries.");
        assertThat(report.get().getOpportunity())
                .isEqualTo("Positive policy signals are concentrated in Semiconductors, Semiconductor Equipment, and Renewable Energy.");
        assertThat(report.get().getRisk())
                .isEqualTo("Track implementation timing, funding details, and demand pull-through before changing investment assumptions.");
    }

    @Test
    void analyzePolicyReturnsEmptyForUnknownPolicy() {
        assertThat(policyAnalysisService.analyzePolicy(999L)).isEmpty();
    }
}
