package com.example.MicroserviceSecondService.Service;

import com.example.MicroServiceOne.Entities.UserWithTasks;
import com.example.MicroserviceSecondService.Configuration.MicroserviceOneClient;
import com.example.MicroserviceSecondService.Dao.AnalysisDao;
import com.example.MicroserviceSecondService.Dao.DataDao;
import com.example.MicroserviceSecondService.Entities.EvaluationResult;
import com.example.MicroserviceSecondService.Entities.analysisData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class EvaluationServiceImpl implements EvaluationService {

    @Autowired
    private DataDao dataDao;

    @Autowired
    private AnalysisDao analysisDao;

    @Autowired
    private MicroserviceOneClient microserviceOneClient;



    @Override
    public EvaluationResult evaluateTasks(String email) {
        // 1. Call Microservice One to get task + user details
        List<UserWithTasks> userTasks = microserviceOneClient.fetchUserTasksByEmail(email);

        if (userTasks.isEmpty()) {
            throw new RuntimeException("No tasks found for email: " + email);
        }

        // Assuming user name is consistent in the response
        String name = userTasks.get(0).getUserName();

        List<String> taskDescriptions = new ArrayList<>();
        for (UserWithTasks userTask : userTasks) {
            String description = userTask.getDescription();
            taskDescriptions.add(description);
        }

        // 2. Get analysis data by email
        List<analysisData> analysisList = analysisDao.findByEMAIL(email);
        List<String> analysisDescriptions = new ArrayList<>();
        for (analysisData analysisData : analysisList) {
            String datadescription = analysisData.getDATADESCRIPTION();
            analysisDescriptions.add(datadescription);
        }

        // 3. Compare task and analysis descriptions
        boolean matched = !Collections.disjoint(taskDescriptions, analysisDescriptions);

        return new EvaluationResult(
                email,
                name,
                taskDescriptions.size(),
                analysisDescriptions.size(),
                matched,
                taskDescriptions,
                analysisDescriptions
        );
    }

}



