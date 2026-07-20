package com.wflin.aiinvestmentplatform.industry;

import java.time.LocalDate;

public class IndustryScore {

    private Long industryId;
    private Integer prosperityScore;
    private Integer capitalScore;
    private Integer policyScore;
    private Integer valuationScore;
    private Integer sentimentScore;
    private LocalDate scoreDate;
    private String summary;

    public IndustryScore() {
    }

    public IndustryScore(Long industryId, Integer prosperityScore, Integer capitalScore, Integer policyScore,
            Integer valuationScore, Integer sentimentScore, LocalDate scoreDate, String summary) {
        this.industryId = industryId;
        this.prosperityScore = validateDimension("prosperityScore", prosperityScore);
        this.capitalScore = validateDimension("capitalScore", capitalScore);
        this.policyScore = validateDimension("policyScore", policyScore);
        this.valuationScore = validateDimension("valuationScore", valuationScore);
        this.sentimentScore = validateDimension("sentimentScore", sentimentScore);
        this.scoreDate = scoreDate;
        this.summary = summary;
    }

    public Long getIndustryId() {
        return industryId;
    }

    public void setIndustryId(Long industryId) {
        this.industryId = industryId;
    }

    public Integer getProsperityScore() {
        return prosperityScore;
    }

    public void setProsperityScore(Integer prosperityScore) {
        this.prosperityScore = validateDimension("prosperityScore", prosperityScore);
    }

    public Integer getCapitalScore() {
        return capitalScore;
    }

    public void setCapitalScore(Integer capitalScore) {
        this.capitalScore = validateDimension("capitalScore", capitalScore);
    }

    public Integer getPolicyScore() {
        return policyScore;
    }

    public void setPolicyScore(Integer policyScore) {
        this.policyScore = validateDimension("policyScore", policyScore);
    }

    public Integer getValuationScore() {
        return valuationScore;
    }

    public void setValuationScore(Integer valuationScore) {
        this.valuationScore = validateDimension("valuationScore", valuationScore);
    }

    public Integer getSentimentScore() {
        return sentimentScore;
    }

    public void setSentimentScore(Integer sentimentScore) {
        this.sentimentScore = validateDimension("sentimentScore", sentimentScore);
    }

    public Integer getTotalScore() {
        return valueOf(prosperityScore) + valueOf(capitalScore) + valueOf(policyScore)
                + valueOf(valuationScore) + valueOf(sentimentScore);
    }

    public LocalDate getScoreDate() {
        return scoreDate;
    }

    public void setScoreDate(LocalDate scoreDate) {
        this.scoreDate = scoreDate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    private static Integer validateDimension(String fieldName, Integer score) {
        if (score == null) {
            return null;
        }
        if (score < 0 || score > 20) {
            throw new IllegalArgumentException(fieldName + " must be between 0 and 20");
        }
        return score;
    }

    private static int valueOf(Integer score) {
        return score == null ? 0 : score;
    }
}
