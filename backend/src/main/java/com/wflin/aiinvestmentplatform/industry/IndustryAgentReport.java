package com.wflin.aiinvestmentplatform.industry;

import java.util.List;

public class IndustryAgentReport {

    private Industry industry;
    private IndustryScore score;
    private List<IndustryStockRelation> stocks;
    private String conclusion;

    public IndustryAgentReport() {
    }

    public IndustryAgentReport(Industry industry, IndustryScore score, List<IndustryStockRelation> stocks,
            String conclusion) {
        this.industry = industry;
        this.score = score;
        this.stocks = stocks;
        this.conclusion = conclusion;
    }

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public IndustryScore getScore() {
        return score;
    }

    public void setScore(IndustryScore score) {
        this.score = score;
    }

    public List<IndustryStockRelation> getStocks() {
        return stocks;
    }

    public void setStocks(List<IndustryStockRelation> stocks) {
        this.stocks = stocks;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }
}
