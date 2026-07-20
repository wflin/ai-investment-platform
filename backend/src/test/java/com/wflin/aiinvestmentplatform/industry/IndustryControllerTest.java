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
