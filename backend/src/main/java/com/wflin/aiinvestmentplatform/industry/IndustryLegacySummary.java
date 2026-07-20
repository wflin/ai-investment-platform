package com.wflin.aiinvestmentplatform.industry;

public class IndustryLegacySummary {

    private Long id;
    private String name;
    private String category;
    private Integer heatScore;
    private Integer prosperityScore;
    private String description;

    public IndustryLegacySummary() {
    }

    public IndustryLegacySummary(Long id, String name, String category, Integer heatScore, Integer prosperityScore,
            String description) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.heatScore = heatScore;
        this.prosperityScore = prosperityScore;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getHeatScore() {
        return heatScore;
    }

    public void setHeatScore(Integer heatScore) {
        this.heatScore = heatScore;
    }

    public Integer getProsperityScore() {
        return prosperityScore;
    }

    public void setProsperityScore(Integer prosperityScore) {
        this.prosperityScore = prosperityScore;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
