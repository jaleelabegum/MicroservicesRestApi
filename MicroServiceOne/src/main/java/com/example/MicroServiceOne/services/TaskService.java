package com.example.MicroServiceOne.services;

import com.example.MicroServiceOne.Entities.TaskSummaryDto;
import com.example.MicroServiceOne.Entities.Tasks;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {

    List<Tasks> getTasks(String email);

    Tasks addTaskDetails(Tasks tasks);

    void deletetasks(Integer id);

    void deletetasksByTaskName(String TaskName);

    List<Tasks> getTasksByUserEmail(String email);

    List<Tasks> getAllUserTasks();

    public List<TaskSummaryDto> getTaskSummariesByForeignKeyUser(String foreignKeyusers);






    //List<Tasks> getAllTasks();

}
