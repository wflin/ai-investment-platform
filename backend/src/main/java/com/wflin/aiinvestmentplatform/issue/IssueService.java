package com.wflin.aiinvestmentplatform.issue;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class IssueService {

    private static final Map<Long, Issue> ISSUES = createIssues();

    public Optional<Issue> findById(Long id) {
        return Optional.ofNullable(ISSUES.get(id));
    }

    private static Map<Long, Issue> createIssues() {
        List<Issue> seedIssues = Arrays.asList(
                new Issue(1L, "Industry analysis REST API", "closed", "medium",
                        "Expose seed industry analysis data through a backend REST API.",
                        "Implemented the first read-only industry endpoint for platform research workflows."),
                new Issue(17L, "GitHub Issue detail API", "open", "medium",
                        "Expose a read-only endpoint for looking up issue details by ID.",
                        "Provides stable issue detail seed data for API clients until persistent issue storage is added.")
        );

        Map<Long, Issue> issuesById = new LinkedHashMap<Long, Issue>();
        for (Issue issue : seedIssues) {
            issuesById.put(issue.getId(), issue);
        }
        return Collections.unmodifiableMap(issuesById);
    }
}
