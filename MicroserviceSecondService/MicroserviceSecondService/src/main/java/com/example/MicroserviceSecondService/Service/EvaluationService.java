package com.example.MicroserviceSecondService.Service;

import com.example.MicroServiceOne.Entities.UserWithTasks;
import com.example.MicroserviceSecondService.Dao.AnalysisDao;
import com.example.MicroserviceSecondService.Entities.EvaluationResult;
import com.example.MicroserviceSecondService.Entities.analysisData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public interface EvaluationService {



    public EvaluationResult evaluateTasks(String email);

}
