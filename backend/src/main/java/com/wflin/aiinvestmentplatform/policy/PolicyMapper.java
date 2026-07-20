package com.wflin.aiinvestmentplatform.policy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PolicyMapper {

    private static final LocalDateTime SEED_TIME = LocalDateTime.of(2026, 1, 1, 0, 0);
    private static final Map<Long, Policy> POLICIES_BY_ID = createPoliciesById();

    public List<Policy> selectLatest() {
        List<Policy> policies = new ArrayList<Policy>(POLICIES_BY_ID.values());
        Collections.sort(policies, new Comparator<Policy>() {
            @Override
            public int compare(Policy first, Policy second) {
                return second.getPublishTime().compareTo(first.getPublishTime());
            }
        });
        return Collections.unmodifiableList(policies);
    }

    public Optional<Policy> selectById(Long id) {
        return Optional.ofNullable(POLICIES_BY_ID.get(id));
    }

    private static Map<Long, Policy> createPoliciesById() {
        List<Policy> policies = Arrays.asList(
                new Policy(1L, "Strategic AI Computing Infrastructure Action Plan",
                        "National Development and Reform Commission",
                        LocalDateTime.of(2026, 7, 15, 9, 0),
                        "Policy encourages advanced computing clusters, semiconductor equipment localization, "
                                + "and energy-efficient data centers.",
                        "INDUSTRIAL_SUPPORT", "HIGH", SEED_TIME, SEED_TIME),
                new Policy(2L, "Renewable Energy Grid Integration Guidance",
                        "National Energy Administration",
                        LocalDateTime.of(2026, 7, 10, 10, 30),
                        "Policy promotes renewable generation consumption, energy storage dispatch, "
                                + "and grid investment coordination.",
                        "ENERGY_TRANSITION", "HIGH", SEED_TIME, SEED_TIME),
                new Policy(3L, "Biopharmaceutical Innovation Review Measures",
                        "National Medical Products Administration",
                        LocalDateTime.of(2026, 6, 25, 14, 0),
                        "Policy improves review efficiency for innovative drugs and clarifies post-market "
                                + "monitoring requirements.",
                        "REGULATORY_OPTIMIZATION", "MEDIUM", SEED_TIME, SEED_TIME)
        );

        Map<Long, Policy> policiesById = new LinkedHashMap<Long, Policy>();
        for (Policy policy : policies) {
            policiesById.put(policy.getId(), policy);
        }
        return Collections.unmodifiableMap(policiesById);
    }
}
