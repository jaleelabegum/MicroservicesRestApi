package com.example.MicroServiceOne.Entities;

public class TaskSummaryDto {
    private String foreignKeyusers;
    private String description;

    public TaskSummaryDto(String foreignKeyusers, String description) {
        this.foreignKeyusers = foreignKeyusers;
        this.description = description;
    }

    public String getForeignKeyusers() {
        return foreignKeyusers;
    }

    public String getDescription() {
        return description;
    }

    public void setForeignKeyusers(String foreignKeyusers) {
        this.foreignKeyusers = foreignKeyusers;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskSummaryDto() {
    }
}
