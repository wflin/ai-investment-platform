package com.wflin.aiinvestmentplatform.stock;

public class Stock {

    private String code;
    private String name;
    private String industry;
    private String market;

    public Stock() {
    }

    public Stock(String code, String name, String industry, String market) {
        this.code = code;
        this.name = name;
        this.industry = industry;
        this.market = market;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }
}
