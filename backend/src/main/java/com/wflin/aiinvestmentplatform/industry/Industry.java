package com.wflin.aiinvestmentplatform.industry;

import java.time.LocalDateTime;

public class Industry {

    private Long id;
    private String industryCode;
    private String industryName;
    private Integer level;
    private Long parentId;
    private String description;
    private String status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public Industry() {
    }

    public Industry(Long id, String industryCode, String industryName, Integer level, Long parentId,
            String description, String status, LocalDateTime createTime, LocalDateTime updateTime) {
        this.id = id;
        this.industryCode = industryCode;
        this.industryName = industryName;
        this.level = level;
        this.parentId = parentId;
        this.description = description;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
