package com.wflin.aiinvestmentplatform.policy;

public class PolicyIndustryRelation {

    private Long policyId;
    private Long industryId;
    private String influenceLevel;
    private String influenceDirection;

    public PolicyIndustryRelation() {
    }

    public PolicyIndustryRelation(Long policyId, Long industryId, String influenceLevel, String influenceDirection) {
        this.policyId = policyId;
        this.industryId = industryId;
        this.influenceLevel = influenceLevel;
        this.influenceDirection = influenceDirection;
    }

    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }

    public Long getIndustryId() {
        return industryId;
    }

    public void setIndustryId(Long industryId) {
        this.industryId = industryId;
    }

    public String getInfluenceLevel() {
        return influenceLevel;
    }

    public void setInfluenceLevel(String influenceLevel) {
        this.influenceLevel = influenceLevel;
    }

    public String getInfluenceDirection() {
        return influenceDirection;
    }

    public void setInfluenceDirection(String influenceDirection) {
        this.influenceDirection = influenceDirection;
    }
}
