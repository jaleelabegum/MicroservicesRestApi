package com.example.MicroServiceOne.Entities;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public class UserWithTasks {

    private String userName;
    private String userEmail;
    private String city;
    private String country;
    private String taskName;
    private String description;
    private Date startDate;
    private String priority;

    public UserWithTasks(String userName, String userEmail, String city, String country,
                       String taskName, String description, Date startDate, String priority) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.city = city;
        this.country = country;
        this.taskName = taskName;
        this.description = description;
        this.startDate = startDate;
        this.priority = priority;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public UserWithTasks() {
    }

}




