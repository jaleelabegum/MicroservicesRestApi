package com.example.MicroserviceSecondService.Dao;

import com.example.MicroserviceSecondService.Entities.analysisData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnalysisDao extends JpaRepository<analysisData, Integer> {

    List<analysisData> findByEMAIL(String EMAIL);
}
