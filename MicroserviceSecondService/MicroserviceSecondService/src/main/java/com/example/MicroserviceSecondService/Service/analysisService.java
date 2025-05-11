package com.example.MicroserviceSecondService.Service;

import com.example.MicroserviceSecondService.Entities.analysisData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface analysisService {

    List<analysisData> getAllData(String EMAIL);

    List<analysisData> getDatafromtasks(String EMAIL);
}
