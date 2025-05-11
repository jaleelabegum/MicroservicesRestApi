package com.example.MicroserviceSecondService.Entities;

import java.util.List;

public class UserTaskDto {
    private String EMAIL;
    private List<String> taskDescriptions;

    public UserTaskDto() {}

    public UserTaskDto(String EMAIL, List<String> taskDescriptions) {
        this.EMAIL = EMAIL;
        this.taskDescriptions = taskDescriptions;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public List<String> getTaskDescriptions() {
        return taskDescriptions;
    }

    @Override
    public String toString() {
        return "UserTaskDto{" +
                "EMAIL='" + EMAIL + '\'' +
                ", taskDescriptions=" + taskDescriptions +
                '}';
    }

    public void setTaskDescriptions(List<String> taskDescriptions) {
        this.taskDescriptions = taskDescriptions;
    }
}
