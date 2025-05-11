package com.example.MicroserviceSecondService.Entities;

import java.util.List;

public class EvaluationResult {

    private String email;
    private String name;
    private int taskCount;
    private int analysisCount;
    private boolean matched;
    private List<String> taskDescriptions;
    private List<String> analysisDescriptions;

    public EvaluationResult(String email, String name, int taskCount, int analysisCount,
                            boolean matched, List<String> taskDescriptions,
                            List<String> analysisDescriptions) {
        this.email = email;
        this.name = name;
        this.taskCount = taskCount;
        this.analysisCount = analysisCount;
        this.matched = matched;
        this.taskDescriptions = taskDescriptions;
        this.analysisDescriptions = analysisDescriptions;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(int taskCount) {
        this.taskCount = taskCount;
    }

    public int getAnalysisCount() {
        return analysisCount;
    }

    public void setAnalysisCount(int analysisCount) {
        this.analysisCount = analysisCount;
    }

    public boolean isMatched() {
        return matched;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    public List<String> getTaskDescriptions() {
        return taskDescriptions;
    }

    public void setTaskDescriptions(List<String> taskDescriptions) {
        this.taskDescriptions = taskDescriptions;
    }

    public List<String> getAnalysisDescriptions() {
        return analysisDescriptions;
    }

    public void setAnalysisDescriptions(List<String> analysisDescriptions) {
        this.analysisDescriptions = analysisDescriptions;
    }

    public EvaluationResult() {
    }
}
