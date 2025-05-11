package com.example.MicroServiceOne.Controllers;

import com.example.MicroServiceOne.DAO.TaskDao;
import com.example.MicroServiceOne.DAO.UserDao;
import com.example.MicroServiceOne.Entities.TaskSummaryDto;
import com.example.MicroServiceOne.Entities.Tasks;
import com.example.MicroServiceOne.Entities.User;
//import com.example.MicroServiceOne.Entities.UserWithTasks;
import com.example.MicroServiceOne.Entities.UserWithTasks;
import com.example.MicroServiceOne.Utilities.UserNotInDatabaseException;
import com.example.MicroServiceOne.Utilities.UserValidator;
import com.example.MicroServiceOne.services.LoginService;
import com.example.MicroServiceOne.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class RestApis {

    @Autowired
    private Tasks tasks;

    @Autowired
    private UserDao userDao;

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserValidator userValidator;


    @Autowired
    private TaskService taskService;

    // Constructor injection of the custom validator
   /* public RestApis(UserValidator userValidator) {
        this.userValidator = userValidator;
    }*/

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(userValidator);  // Add custom validator to binder
    }

    @RequestMapping("/userDetails")
    public User getUserDetails() {
        return new User("Jali", "jalsu4321@gmail.com", "jaleelaJalz@13", 25, "chennai", "India", 12345);
    }

    @RequestMapping("/TaskDetails")
    public String taskData(TaskDao taskDao) {
        return "taskName:" + tasks.getTaskName() + ",task priority:" + tasks.getPriority();
    }

    @GetMapping("/fetchAllUserDetails")
    public List<User> getAllUserDetails() {
        return userDao.findAll();
    }

    @PostMapping("/saveUserDetails")
    public ResponseEntity<?> createUser(@RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        User savedUser = userDao.save(user);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/user")
    public List<Tasks> getTasksByUserEmail(@RequestParam String email) {
        return taskDao.findByForeignKeyusers(email);
    }

    @PostMapping("/addTasks")
    public Object addTask(@RequestBody Tasks taskRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> {
                errorMap.put(error.getField(), error.getDefaultMessage());
            });
            return ResponseEntity.badRequest().body(errorMap);
        }
        Tasks task = new Tasks();
        task.setTaskName(task.getTaskName());
        task.setDescription(task.getDescription());
        task.setStartDate(task.getStartDate());
        task.setPriority(task.getPriority());
        task.setForeignKeyusers(taskRequest.getForeignKeyusers());
        return taskDao.save(task);
    }

    @DeleteMapping("/deleteByUuid/{uuid}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer uuid) {
        try {
            String result = loginService.deleteUserByUuid(uuid);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while deleting the user.");
        }
    }

    @PutMapping("/updateUser/{uuid}")
    public ResponseEntity<String> updateUser(@PathVariable Integer uuid, @RequestBody User user) {
        try {
            String message = loginService.updateUser(uuid, user);
            return ResponseEntity.ok(message);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Update failed due to server error.");
        }
    }

    @GetMapping("/allTasksDetails")
    public List<Tasks> getAllTasks() {
        return taskDao.findAll();
    }

    //this postmapping for passing a value from a main class.
    @PostMapping("/createTasks")
    public ResponseEntity<?> createTask1(@RequestBody Tasks task) {
        if (task.getPriority() == null || task.getPriority().isBlank()) {
            return ResponseEntity.badRequest().body("Task priority is required.");
        }

        taskDao.save(task);
        return ResponseEntity.ok("Task created successfully");
    }

    @PostMapping("/AddTasksDetails")
    public ResponseEntity<String> createTask(@RequestBody Tasks task) {
        if (task.getPriority() == null) {
            throw new IllegalArgumentException("Task priority must not be null");
        }
        taskDao.save(task);
        return ResponseEntity.ok("Task created successfully");
    }

    // Optional: Handle global exception for null priority
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body("Error: " + ex.getMessage());
    }

    @GetMapping("/user-tasks/{email}")
    public ResponseEntity<?> getUserTasks(@PathVariable String email) {
        Optional<User> userOpt = userDao.findByEmail(email);

        if (userOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        List<Tasks> tasks = taskDao.findTasksByUserEmail(email);
        return ResponseEntity.ok(tasks);
    }
    // @GetMapping("/tasksByUserEmail/{email}")
    //public List<Tasks> getTasksByUserEmails(@RequestParam String email) {
    //  return taskDao.findTasksByUserEmail(email);
    //}

    @GetMapping("/userTasks")
    public ResponseEntity<List<UserWithTasks>> getTasksByUserEmailDetails(@RequestParam String email) {
        List<UserWithTasks> tasks = taskDao.getTasksForUser(email);
        if (tasks.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/usersByCity/{city}")
    public ResponseEntity<List<User>> getUsersByCity(@PathVariable String city) throws UserNotInDatabaseException {
        List<User> users = loginService.getUsersByCity(city);
        return ResponseEntity.ok(users);
    }


    @GetMapping("/userDetailsById/{uuid}")
    public List<User> getUserDetailsById(@PathVariable Integer uuid) {
        return loginService.getUserDetailsByuuid(uuid);
    }

    @GetMapping("/allTasks")
    public ResponseEntity<List<Tasks>> getAllTasksDetails() {
        List<Tasks> tasks = taskService.getAllUserTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/summaries/{foreignKeyusers}")
    public List<TaskSummaryDto> getTaskSummariesByUser(@PathVariable String foreignKeyusers) {
        return taskService.getTaskSummariesByForeignKeyUser(foreignKeyusers);
    }


   /* @GetMapping("/all")
    public ResponseEntity<List<Tasks>> getAllTask() {
        List<Tasks> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    } */

   /* @DeleteMapping("/deleteByuuid/{uuid}")
    public ResponseEntity<String> deleteUserByUuid(@PathVariable Integer uuid) {
        try {
            boolean deleted = userDao.deleteUserById(uuid);
            if (deleted) {
                return ResponseEntity.ok("User deleted successfully with UUID: " + uuid);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with UUID: " + uuid);
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }*/


 /*   @GetMapping("/user-tasks/{email}")
    public ResponseEntity<?> getUserWithTasks(@PathVariable String email) {
        email = email.trim().toLowerCase();

        Optional<User> userOpt = userDao.findByEmail(email);
        if (userOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User not found with email: " + email);
        }

       // List<Tasks> tasks = taskDao.findByForeignKeyusers(email);
        //UserWithTasks dto = new UserWithTasks(userOpt.get(), tasks);
        return ResponseEntity.ok(userOpt);
    }*/
    }




