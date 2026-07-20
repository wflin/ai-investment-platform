package com.wflin.aiinvestmentplatform.issue;

public class Issue {

    private Long id;
    private String title;
    private String status;
    private String priority;
    private String summary;
    private String description;

    public Issue() {
    }

    public Issue(Long id, String title, String status, String priority, String summary, String description) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.priority = priority;
        this.summary = summary;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
