package com.wflin.aiinvestmentplatform.industry;

import java.util.List;

public class IndustryAgent {

    public IndustryAgentReport analyze(Industry industry, IndustryScore score, List<IndustryStockRelation> stocks) {
        String conclusion = buildConclusion(industry, score, stocks);
        return new IndustryAgentReport(industry, score, stocks, conclusion);
    }

    private String buildConclusion(Industry industry, IndustryScore score, List<IndustryStockRelation> stocks) {
        return industry.getIndustryName() + " has a V1 industry score of " + score.getTotalScore()
                + "/100 across prosperity, capital, policy, valuation, and sentiment dimensions. "
                + "The agent is tracking " + stocks.size()
                + " related stocks and should prioritize score changes, policy catalysts, and valuation risk.";
    }
}
