package com.wflin.aiinvestmentplatform.policy;

public class PolicyIndustryImpactDto {

    private Long policyId;
    private Long industryId;
    private String industryName;
    private String influenceLevel;
    private String influenceDirection;

    public PolicyIndustryImpactDto() {
    }

    public PolicyIndustryImpactDto(Long policyId, Long industryId, String industryName, String influenceLevel,
            String influenceDirection) {
        this.policyId = policyId;
        this.industryId = industryId;
        this.industryName = industryName;
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

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
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
