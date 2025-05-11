package com.example.MicroServiceOne.Entities;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

//@Contract(pure = true)
@Entity
@Component
@Table(name="TasksDetails")
public class Tasks {

    @Id
    @Column(name="TaskId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="TasksName")
    private String taskName;
    @Column(name="TaskDescription")
    private String description;
    @Column(name="StartDate")
    private Date startDate;
    @Column(name="TaskPriority")
    private String priority;
    @Column(name="ForeignerKeyUser")
    private String foreignKeyusers;

    public Tasks(String taskName, String description, Date startDate, String priority, String foreignKeyusers) {
        //this.id = id;
        this.taskName = taskName;
        this.description = description;
        this.startDate = startDate;
        this.priority = priority;
        this.foreignKeyusers = foreignKeyusers;
    }

    public Tasks() {
    }



    // public int getId() {
     //   return id;
    //}

    public String getDescription() {
        return description;
    }



    public String getPriority() {
        return priority;
    }

    public void setForeignKeyusers(String foreignKeyusers) {
        this.foreignKeyusers = foreignKeyusers;
    }

    //public void setId(int id) {
     //   this.id = id;
    //}

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getForeignKeyusers() {
        return foreignKeyusers;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @PrePersist
    void getStartTimeOperation(){
        Date startdate = new Date();
    }

   /* @PrePersist
    void getEndTimeOperation(){
        Date enddate = new Date();
    }*/

    @ManyToOne
    @JoinColumn(name = "ForeignerKeyUser", referencedColumnName = "UserMailid", insertable = false, updatable = false)
    private User user;
}
