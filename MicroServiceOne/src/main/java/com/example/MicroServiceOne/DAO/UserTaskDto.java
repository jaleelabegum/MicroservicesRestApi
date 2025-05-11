package com.example.MicroServiceOne.DAO;
import java.util.List;

public class UserTaskDto {
    private String email;
    private List<String> taskDescriptions;

    public UserTaskDto(String email, List<String> taskDescriptions) {
        this.email = email;
        this.taskDescriptions = taskDescriptions;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getTaskDescriptions() {
        return taskDescriptions;
    }

    public void setTaskDescriptions(List<String> taskDescriptions) {
        this.taskDescriptions = taskDescriptions;
    }

    public UserTaskDto() {
    }
}
