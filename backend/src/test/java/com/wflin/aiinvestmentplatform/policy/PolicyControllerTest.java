package com.wflin.aiinvestmentplatform.policy;

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

@WebMvcTest(PolicyController.class)
@Import({PolicyService.class, PolicyAnalysisService.class})
class PolicyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getLatestPoliciesReturnsSeedPolicyData() throws Exception {
        mockMvc.perform(get("/api/policies/latest"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(3))))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].title").value("Strategic AI Computing Infrastructure Action Plan"))
                .andExpect(jsonPath("$[0].source").value("National Development and Reform Commission"))
                .andExpect(jsonPath("$[0].policyType").value("INDUSTRIAL_SUPPORT"))
                .andExpect(jsonPath("$[0].importanceLevel").value("HIGH"));
    }

    @Test
    void getPolicyReturnsDetail() throws Exception {
        mockMvc.perform(get("/api/policies/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.title").value("Renewable Energy Grid Integration Guidance"))
                .andExpect(jsonPath("$.source").value("National Energy Administration"))
                .andExpect(jsonPath("$.policyType").value("ENERGY_TRANSITION"))
                .andExpect(jsonPath("$.importanceLevel").value("HIGH"));
    }

    @Test
    void getPolicyReturnsNotFoundForUnknownPolicy() throws Exception {
        mockMvc.perform(get("/api/policies/999"))
                .andExpect(status().isNotFound());
    }

    @Test
    void getPolicyIndustriesReturnsMappedIndustryImpacts() throws Exception {
        mockMvc.perform(get("/api/policies/1/industries"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].policyId").value(1))
                .andExpect(jsonPath("$[0].industryId").value(1))
                .andExpect(jsonPath("$[0].industryName").value("Semiconductors"))
                .andExpect(jsonPath("$[0].influenceLevel").value("HIGH"))
                .andExpect(jsonPath("$[0].influenceDirection").value("POSITIVE"));
    }

    @Test
    void getPolicyIndustriesReturnsNotFoundForUnknownPolicy() throws Exception {
        mockMvc.perform(get("/api/policies/999/industries"))
                .andExpect(status().isNotFound());
    }

    @Test
    void getPolicyAnalysisReturnsAgentReport() throws Exception {
        mockMvc.perform(get("/api/policies/1/analysis"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.policy.id").value(1))
                .andExpect(jsonPath("$.policy.title").value("Strategic AI Computing Infrastructure Action Plan"))
                .andExpect(jsonPath("$.industries", hasSize(3)))
                .andExpect(jsonPath("$.summary")
                        .value("Strategic AI Computing Infrastructure Action Plan from National Development and Reform Commission is a HIGH importance INDUSTRIAL_SUPPORT policy affecting 3 tracked industries."))
                .andExpect(jsonPath("$.opportunity")
                        .value("Positive policy signals are concentrated in Semiconductors, Semiconductor Equipment, and Renewable Energy."))
                .andExpect(jsonPath("$.risk")
                        .value("Track implementation timing, funding details, and demand pull-through before changing investment assumptions."))
                .andExpect(jsonPath("$.recommendation")
                        .value("Use the policy as a research catalyst and refresh industry policy scores for high-influence sectors."));
    }

    @Test
    void getPolicyAnalysisReturnsNotFoundForUnknownPolicy() throws Exception {
        mockMvc.perform(get("/api/policies/999/analysis"))
                .andExpect(status().isNotFound());
    }
}
