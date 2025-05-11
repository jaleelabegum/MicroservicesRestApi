package com.example.MicroServiceOne.DAO;

import com.example.MicroServiceOne.Entities.TaskSummaryDto;
import com.example.MicroServiceOne.Entities.Tasks;
//import com.example.MicroServiceOne.Entities.UserWithTasks;
import com.example.MicroServiceOne.Entities.UserWithTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskDao extends JpaRepository<Tasks, Integer> {

    @Query(value = "SELECT * FROM TasksDetails where TasksName=:TasksName", nativeQuery = true)
    List<Tasks> findByTasksName(String TasksName);


    void deleteByTaskName(String taskName);

    @Query(value="SELECT * FROM TasksDetails where email=:email", nativeQuery = true)
    List<Tasks> findByForeignKeyusers(String email);

    @Query("SELECT t FROM Tasks t WHERE t.foreignKeyusers = :email")
    List<Tasks> findTasksByUserEmail(String email);

    //@Query(value = "SELECT * FROM tasks t JOIN users u ON t.foreignKeyUsers = u.email WHERE u.email = :email", nativeQuery = true)
    //List<Tasks> findTasksByUserEmailNative(@Param("email") String email);


    @Query("SELECT new com.example.MicroServiceOne.Entities.UserWithTasks(" +
            "u.name, u.email, u.city, u.country, " +
            "t.taskName, t.description, t.startDate, t.priority) " +
            "FROM com.example.MicroServiceOne.Entities.Tasks t " +
            "JOIN com.example.MicroServiceOne.Entities.User u ON t.foreignKeyusers = u.email " +
            "WHERE u.email = :email")
    List<UserWithTasks> findUserTasksByEmail(@Param("email") String email);

    @Query("SELECT new com.example.MicroServiceOne.Entities.UserWithTasks(" +
            "u.name, u.email, u.city, u.country, " +
            "t.taskName, t.description, t.startDate, t.priority) " +
            "FROM com.example.MicroServiceOne.Entities.Tasks t " +
            "JOIN com.example.MicroServiceOne.Entities.User u ON t.foreignKeyusers = u.email " +
            "WHERE u.email = :email")
    List<UserWithTasks> getTasksForUser(@Param("email") String email);

    @Query("SELECT new com.example.MicroServiceOne.Entities.TaskSummaryDto(t.foreignKeyusers, t.description) " +
            "FROM Tasks t WHERE t.foreignKeyusers = :foreignKeyusers")
    List<TaskSummaryDto> findTaskSummariesByForeignKeyUser(@Param("foreignKeyusers") String foreignKeyusers);



    @Query("SELECT t FROM Tasks t")
    List<Tasks> findAllTasks();






    //@Query("SELECT t FROM Tasks t")
    //List<Tasks> findAllTasks();


    //public void deleteByTaskName();

    //List<Tasks> findByffkusers(String email);

    //void save(Tasks tasks);
}
