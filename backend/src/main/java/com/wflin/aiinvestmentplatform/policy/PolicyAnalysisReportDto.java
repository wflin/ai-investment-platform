package com.wflin.aiinvestmentplatform.policy;

import java.util.List;

public class PolicyAnalysisReportDto {

    private Policy policy;
    private List<PolicyIndustryImpactDto> industries;
    private String summary;
    private String opportunity;
    private String risk;
    private String recommendation;

    public PolicyAnalysisReportDto() {
    }

    public PolicyAnalysisReportDto(Policy policy, List<PolicyIndustryImpactDto> industries, String summary,
            String opportunity, String risk, String recommendation) {
        this.policy = policy;
        this.industries = industries;
        this.summary = summary;
        this.opportunity = opportunity;
        this.risk = risk;
        this.recommendation = recommendation;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    public List<PolicyIndustryImpactDto> getIndustries() {
        return industries;
    }

    public void setIndustries(List<PolicyIndustryImpactDto> industries) {
        this.industries = industries;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getOpportunity() {
        return opportunity;
    }

    public void setOpportunity(String opportunity) {
        this.opportunity = opportunity;
    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }
}
