package com.wflin.aiinvestmentplatform.industry;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class IndustryController {

    private final IndustryService industryService;

    public IndustryController(IndustryService industryService) {
        this.industryService = industryService;
    }

    @GetMapping("/api/industry/list")
    public List<Industry> getIndustryList(@RequestParam(value = "level", required = false) Integer level,
            @RequestParam(value = "parentId", required = false) Long parentId) {
        return industryService.findAll(level, parentId);
    }

    @GetMapping("/api/industry/{id}")
    public ResponseEntity<Industry> getIndustry(@PathVariable("id") Long id) {
        return industryService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/api/industry/{id}/stocks")
    public ResponseEntity<List<IndustryStockRelation>> getIndustryStocks(@PathVariable("id") Long id) {
        return industryService.findStocksByIndustryId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/api/industry/{id}/score")
    public ResponseEntity<IndustryScore> getIndustryScore(@PathVariable("id") Long id) {
        return industryService.findScoreByIndustryId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/api/industry/{id}/analysis")
    public ResponseEntity<IndustryAgentReport> getIndustryAnalysis(@PathVariable("id") Long id) {
        return industryService.analyzeIndustry(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/api/industries")
    public List<IndustryLegacySummary> getIndustries() {
        return industryService.findLegacySummaries();
    }
}
