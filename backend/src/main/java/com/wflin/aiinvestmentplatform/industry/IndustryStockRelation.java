package com.wflin.aiinvestmentplatform.industry;

public class IndustryStockRelation {

    private String stockCode;
    private String stockName;
    private Long industryId;

    public IndustryStockRelation() {
    }

    public IndustryStockRelation(String stockCode, String stockName, Long industryId) {
        this.stockCode = stockCode;
        this.stockName = stockName;
        this.industryId = industryId;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public Long getIndustryId() {
        return industryId;
    }

    public void setIndustryId(Long industryId) {
        this.industryId = industryId;
    }
}
