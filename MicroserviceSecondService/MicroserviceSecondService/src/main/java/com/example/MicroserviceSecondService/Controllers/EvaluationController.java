package com.example.MicroserviceSecondService.Controllers;

import com.example.MicroserviceSecondService.Entities.EvaluationResult;
import com.example.MicroserviceSecondService.Service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EvaluationController {


    @Autowired
    private EvaluationService evaluationService;

    @GetMapping("/evaluation")
    public ResponseEntity<EvaluationResult> evaluate(@RequestParam String email) {
        EvaluationResult result = evaluationService.evaluateTasks(email);
        return ResponseEntity.ok(result);
    }


}
