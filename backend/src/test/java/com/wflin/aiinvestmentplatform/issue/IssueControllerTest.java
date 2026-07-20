package com.wflin.aiinvestmentplatform.issue;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(IssueController.class)
@Import(IssueService.class)
class IssueControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getIssueReturnsSeedIssueDetail() throws Exception {
        mockMvc.perform(get("/api/issues/17"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(17))
                .andExpect(jsonPath("$.title").value("GitHub Issue detail API"))
                .andExpect(jsonPath("$.status").value("open"))
                .andExpect(jsonPath("$.priority").value("medium"))
                .andExpect(jsonPath("$.summary")
                        .value("Expose a read-only endpoint for looking up issue details by ID."))
                .andExpect(jsonPath("$.description")
                        .value("Provides stable issue detail seed data for API clients until persistent issue storage is added."));
    }

    @Test
    void getIssueReturnsNotFoundForUnknownIssue() throws Exception {
        mockMvc.perform(get("/api/issues/999"))
                .andExpect(status().isNotFound());
    }
}
