package com.example.MicroserviceSecondService.Dao;

import com.example.MicroserviceSecondService.Entities.analysisData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataDao extends JpaRepository<analysisData,Integer> {

    @Query(value = "Select * from analysis_data where EMAIL=:EMAIL",nativeQuery = true)
    List<analysisData> getAllDatasBasedOnMail(@Param("EMAIL") String EMAIL);

    @Query(value = "SELECT d FROM analysis_data d WHERE d.EMAIL = :EMAIL",nativeQuery = true)
    List<analysisData> findByEmailAddress(@Param("EMAIL") String email);


}
