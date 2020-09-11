package com.sensorplatform.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class WaterLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deviceId;

    @CreationTimestamp
    private Timestamp persistedDate;

    private Double waterLevel;

    private Integer damnStatus;

    public WaterLevel() {
    }

    public WaterLevel(String deviceId, Double waterLevel, Integer damnStatus) {
        this.deviceId = deviceId;
        this.waterLevel = waterLevel;
        this.damnStatus = damnStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Timestamp getPersistedDate() {
        return persistedDate;
    }

    public void setPersistedDate(Timestamp persistedDate) {
        this.persistedDate = persistedDate;
    }

    public Double getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(Double waterLevel) {
        this.waterLevel = waterLevel;
    }

    public Integer getDamnStatus() {
        return damnStatus;
    }

    public void setDamnStatus(Integer damnStatus) {
        this.damnStatus = damnStatus;
    }

    @Override
    public String toString() {
        return "WaterLevel{" +
                "id=" + id +
                ", deviceId='" + deviceId + '\'' +
                ", persistedDate=" + persistedDate +
                ", waterLevel=" + waterLevel +
                ", damnStatus=" + damnStatus +
                '}';
    }
}
