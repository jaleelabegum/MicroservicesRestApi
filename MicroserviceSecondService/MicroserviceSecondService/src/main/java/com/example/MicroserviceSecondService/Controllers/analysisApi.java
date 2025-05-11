package com.example.MicroserviceSecondService.Controllers;

import com.example.MicroserviceSecondService.Entities.analysisData;
import com.example.MicroserviceSecondService.Service.analysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class analysisApi {

    @Autowired(required=true)
    private analysisService analysis;

//for testing purpose
    @GetMapping("/showDatas")
    public String test(){
        return "hello";
    }

    @GetMapping("/getAll")
    public List<analysisData> getAllAnalysisData(@RequestParam String EMAIL) {
        return analysis.getAllData(EMAIL);
    }
}
