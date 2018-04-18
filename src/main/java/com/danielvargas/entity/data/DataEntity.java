package com.danielvargas.entity.data;

import javax.persistence.*;

@Entity
public class DataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String rfid;
    private int stationNumber;
    private String userId;
    private int sensor2;
    private int sensor3;
    private int sensor4;

    private Long timeInSeconds;

    public DataEntity() {
    }

    public DataEntity(String rfid, int sensor1, int sensor2, int sensor3, int sensor4, Long time) {
        this.rfid = rfid;
        this.stationNumber = sensor1;
        this.sensor2 = sensor2;
        this.sensor3 = sensor3;
        this.sensor4 = sensor4;
        this.timeInSeconds = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public int getStationNumber() {
        return stationNumber;
    }

    public void setStationNumber(int stationNumber) {
        this.stationNumber = stationNumber;
    }

    public int getSensor2() {
        return sensor2;
    }

    public void setSensor2(int sensor2) {
        this.sensor2 = sensor2;
    }

    public int getSensor3() {
        return sensor3;
    }

    public void setSensor3(int sensor3) {
        this.sensor3 = sensor3;
    }

    public int getSensor4() {
        return sensor4;
    }

    public void setSensor4(int sensor4) {
        this.sensor4 = sensor4;
    }

    public Long getTimeInSeconds() {
        return timeInSeconds;
    }

    public void setTimeInSeconds(Long timeInSeconds) {
        this.timeInSeconds = timeInSeconds;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
