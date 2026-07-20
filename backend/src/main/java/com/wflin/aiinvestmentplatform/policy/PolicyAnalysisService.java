package com.wflin.aiinvestmentplatform.policy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class PolicyAnalysisService {

    private final PolicyService policyService;

    public PolicyAnalysisService(PolicyService policyService) {
        this.policyService = policyService;
    }

    public Optional<PolicyAnalysisReportDto> analyzePolicy(Long policyId) {
        Optional<Policy> policy = policyService.findById(policyId);
        if (!policy.isPresent()) {
            return Optional.empty();
        }

        List<PolicyIndustryImpactDto> industries =
                policyService.findIndustriesByPolicyId(policyId).orElse(new ArrayList<PolicyIndustryImpactDto>());
        String industryNames = formatIndustryNames(industries);
        String summary = policy.get().getTitle() + " from " + policy.get().getSource()
                + " is a " + policy.get().getImportanceLevel() + " importance "
                + policy.get().getPolicyType() + " policy affecting " + industries.size()
                + " tracked industries.";
        String opportunity = buildOpportunity(industryNames);
        String risk = "Track implementation timing, funding details, and demand pull-through before changing "
                + "investment assumptions.";
        String recommendation = "Use the policy as a research catalyst and refresh industry policy scores for "
                + "high-influence sectors.";

        return Optional.of(new PolicyAnalysisReportDto(policy.get(), industries, summary, opportunity, risk,
                recommendation));
    }

    private String buildOpportunity(String industryNames) {
        if (industryNames.length() == 0) {
            return "No tracked industry impact has been mapped yet.";
        }
        return "Positive policy signals are concentrated in " + industryNames + ".";
    }

    private String formatIndustryNames(List<PolicyIndustryImpactDto> industries) {
        List<String> names = new ArrayList<String>();
        for (PolicyIndustryImpactDto industry : industries) {
            if (industry.getIndustryName() != null && industry.getIndustryName().length() > 0) {
                names.add(industry.getIndustryName());
            }
        }

        if (names.isEmpty()) {
            return "";
        }
        if (names.size() == 1) {
            return names.get(0);
        }
        if (names.size() == 2) {
            return names.get(0) + " and " + names.get(1);
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < names.size(); i++) {
            if (i > 0) {
                builder.append(i == names.size() - 1 ? ", and " : ", ");
            }
            builder.append(names.get(i));
        }
        return builder.toString();
    }
}
