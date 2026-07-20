package com.wflin.aiinvestmentplatform.industry;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(IndustryController.class)
@Import(IndustryService.class)
class IndustryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getIndustryListReturnsV1IndustryData() throws Exception {
        mockMvc.perform(get("/api/industry/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(5))))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].industryCode").value("SW-TECH-SEMIS"))
                .andExpect(jsonPath("$[0].industryName").value("Semiconductors"))
                .andExpect(jsonPath("$[0].level").value(1))
                .andExpect(jsonPath("$[0].description")
                        .value("Chip design, manufacturing, equipment, and materials."))
                .andExpect(jsonPath("$[0].status").value("ACTIVE"));
    }

    @Test
    void getIndustryListFiltersByLevelAndParent() throws Exception {
        mockMvc.perform(get("/api/industry/list").param("level", "2").param("parentId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id").value(4))
                .andExpect(jsonPath("$[0].industryName").value("Semiconductor Equipment"))
                .andExpect(jsonPath("$[0].parentId").value(1));
    }

    @Test
    void getIndustryReturnsDetail() throws Exception {
        mockMvc.perform(get("/api/industry/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.industryCode").value("SW-TECH-SEMIS"))
                .andExpect(jsonPath("$.industryName").value("Semiconductors"))
                .andExpect(jsonPath("$.level").value(1))
                .andExpect(jsonPath("$.status").value("ACTIVE"));
    }

    @Test
    void getIndustryReturnsNotFoundForUnknownIndustry() throws Exception {
        mockMvc.perform(get("/api/industry/999"))
                .andExpect(status().isNotFound());
    }

    @Test
    void getIndustryStocksReturnsRelatedStocks() throws Exception {
        mockMvc.perform(get("/api/industry/1/stocks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].stockCode").value("688981"))
                .andExpect(jsonPath("$[0].stockName").value("Semiconductor Manufacturing International"))
                .andExpect(jsonPath("$[0].industryId").value(1));
    }

    @Test
    void getIndustryStocksReturnsNotFoundForUnknownIndustry() throws Exception {
        mockMvc.perform(get("/api/industry/999/stocks"))
                .andExpect(status().isNotFound());
    }

    @Test
    void getIndustryScoreReturnsFiveDimensionScore() throws Exception {
        mockMvc.perform(get("/api/industry/1/score"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.industryId").value(1))
                .andExpect(jsonPath("$.prosperityScore").value(18))
                .andExpect(jsonPath("$.capitalScore").value(19))
                .andExpect(jsonPath("$.policyScore").value(18))
                .andExpect(jsonPath("$.valuationScore").value(17))
                .andExpect(jsonPath("$.sentimentScore").value(18))
                .andExpect(jsonPath("$.totalScore").value(90));
    }

    @Test
    void getIndustryScoreReturnsNotFoundForUnknownIndustry() throws Exception {
        mockMvc.perform(get("/api/industry/999/score"))
                .andExpect(status().isNotFound());
    }

    @Test
    void getIndustryAnalysisReturnsAgentReport() throws Exception {
        mockMvc.perform(get("/api/industry/1/analysis"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.industry.id").value(1))
                .andExpect(jsonPath("$.industry.industryName").value("Semiconductors"))
                .andExpect(jsonPath("$.score.totalScore").value(90))
                .andExpect(jsonPath("$.stocks", hasSize(2)))
                .andExpect(jsonPath("$.conclusion")
                        .value("Semiconductors has a V1 industry score of 90/100 across prosperity, capital, policy, valuation, and sentiment dimensions. The agent is tracking 2 related stocks and should prioritize score changes, policy catalysts, and valuation risk."));
    }

    @Test
    void getIndustryAnalysisReturnsNotFoundForUnknownIndustry() throws Exception {
        mockMvc.perform(get("/api/industry/999/analysis"))
                .andExpect(status().isNotFound());
    }

    @Test
    void getIndustriesReturnsSeedIndustryData() throws Exception {
        mockMvc.perform(get("/api/industries"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(1))))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Semiconductors"))
                .andExpect(jsonPath("$[0].category").value("Technology"))
                .andExpect(jsonPath("$[0].heatScore").value(92))
                .andExpect(jsonPath("$[0].prosperityScore").value(88));
    }
}
