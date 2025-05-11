package com.example.MicroserviceSecondService.Service;

import com.example.MicroserviceSecondService.Dao.DataDao;
import com.example.MicroserviceSecondService.Entities.analysisData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;



@Service
public class analysisServieimpl implements analysisService {


    @Autowired
    private DataDao dataDao;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<analysisData> getAllData(String EMAIL) {
        return dataDao.getAllDatasBasedOnMail(EMAIL);
    }

    @Override
    public List<analysisData> getDatafromtasks(String EMAIL) {
        return List.of();
    }

    /*@Override
    public List<analysisData> getData(String EMAIL) {
        return List.of();
    }*/


    public String getDataFromTasks() {
        String url = "http://localhost:8081/allTasks";
        String response = restTemplate.getForObject(url, String.class);
        return response;
    }



}

