package com.example.MicroserviceSecondService.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="analysis_data")
public class analysisData {

    @Column(name="ID")
    @Id
    private Integer ID;

    @Column(name="DATADESCRIPTION")
    private String DATADESCRIPTION;

    @Column(name="DATE")
    private String DATE;

    @Column(name="EMAIL")
    private String EMAIL;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getDATADESCRIPTION() {
        return DATADESCRIPTION;
    }

    public void setDATADESCRIPTION(String DATADESCRIPTION) {
        this.DATADESCRIPTION = DATADESCRIPTION;
    }

    public String getDATE() {
        return DATE;
    }

    public void setDATE(String DATE) {
        this.DATE = DATE;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public analysisData(Integer ID, String DATADESCRIPTION, String DATE, String EMAIL) {
        this.ID = ID;
        this.DATADESCRIPTION = DATADESCRIPTION;
        this.DATE = DATE;
        this.EMAIL = EMAIL;
    }

    public analysisData() {
    }

    @PrePersist
    void getTimeOperation(){
        this.DATE= String.valueOf(new Date());
    }

}
