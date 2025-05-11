package com.example.MicroServiceOne.services;

import com.example.MicroServiceOne.DAO.TaskDao;
import com.example.MicroServiceOne.Entities.TaskSummaryDto;
import com.example.MicroServiceOne.Entities.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskDao tasksDao;
    @Override
    public List<Tasks> getTasks(String email) {
        return tasksDao.findAll();
    }

    @Override
    public Tasks addTaskDetails(Tasks tasks) {
        return tasksDao.save(tasks);
    }

    @Override
    public void deletetasks(Integer id) {
        tasksDao.deleteById(id);

    }

    @Override
    public void deletetasksByTaskName(String TaskName) {
        tasksDao.deleteByTaskName(TaskName);

    }

    @Override
    public List<Tasks> getTasksByUserEmail(String email) {
        return tasksDao.findTasksByUserEmail(email);
    }

    @Override
    public List<Tasks> getAllUserTasks() {
            return tasksDao.findAllTasks();
        }

    @Override
    public List<TaskSummaryDto> getTaskSummariesByForeignKeyUser(String foreignKeyusers) {
        return tasksDao.findTaskSummariesByForeignKeyUser(foreignKeyusers);
    }


    //  @Override
   // public List<Tasks> getAllTasks() {
    //    return tasksDao.findAllTasks();
   // }
}

