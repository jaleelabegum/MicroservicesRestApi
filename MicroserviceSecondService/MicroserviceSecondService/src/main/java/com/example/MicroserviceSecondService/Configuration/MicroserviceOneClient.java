package com.example.MicroserviceSecondService.Configuration;


import com.example.MicroServiceOne.Entities.UserWithTasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class MicroserviceOneClient {
    private static final String TASK_SERVICE_URL = "http://localhost:8081/userTasks?email=";

    @Autowired
    private RestTemplate restTemplate;

    public List<UserWithTasks> fetchUserTasksByEmail(String email) {
        ResponseEntity<UserWithTasks[]> response = restTemplate.getForEntity(
                TASK_SERVICE_URL + email, UserWithTasks[].class);

        if (response.getBody() != null) {
            return Arrays.asList(response.getBody());
        } else {
            return List.of();
        }
    }

  



    }

