package com.wflin.aiinvestmentplatform.stock;

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

@WebMvcTest(StockController.class)
@Import(StockService.class)
class StockControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getStocksReturnsSeedStockData() throws Exception {
        mockMvc.perform(get("/api/stocks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(1))))
                .andExpect(jsonPath("$[0].code").value("600519"))
                .andExpect(jsonPath("$[0].name").value("Kweichow Moutai"))
                .andExpect(jsonPath("$[0].industry").value("Consumer Staples"))
                .andExpect(jsonPath("$[0].market").value("Shanghai Stock Exchange"));
    }

    @Test
    void getStocksFiltersByIndustry() throws Exception {
        mockMvc.perform(get("/api/stocks").param("industry", "semiconductors"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].code").value("688981"))
                .andExpect(jsonPath("$[0].industry").value("Semiconductors"));
    }

    @Test
    void getStockReturnsSeedStockDetail() throws Exception {
        mockMvc.perform(get("/api/stocks/300750"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("300750"))
                .andExpect(jsonPath("$.name").value("Contemporary Amperex Technology"))
                .andExpect(jsonPath("$.industry").value("Renewable Energy"))
                .andExpect(jsonPath("$.market").value("Shenzhen Stock Exchange"));
    }

    @Test
    void getStockReturnsNotFoundForUnknownStock() throws Exception {
        mockMvc.perform(get("/api/stocks/000000"))
                .andExpect(status().isNotFound());
    }
}
