package com.wflin.aiinvestmentplatform.policy;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    private final PolicyService policyService;
    private final PolicyAnalysisService policyAnalysisService;

    public PolicyController(PolicyService policyService, PolicyAnalysisService policyAnalysisService) {
        this.policyService = policyService;
        this.policyAnalysisService = policyAnalysisService;
    }

    @GetMapping("/latest")
    public List<Policy> getLatestPolicies() {
        return policyService.findLatest();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Policy> getPolicy(@PathVariable("id") Long id) {
        return policyService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/industries")
    public ResponseEntity<List<PolicyIndustryImpactDto>> getPolicyIndustries(@PathVariable("id") Long id) {
        return policyService.findIndustriesByPolicyId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/analysis")
    public ResponseEntity<PolicyAnalysisReportDto> getPolicyAnalysis(@PathVariable("id") Long id) {
        return policyAnalysisService.analyzePolicy(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
