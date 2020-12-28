package com.sensorplatform.database.model;

import javax.persistence.*;

@Entity
public class WaterLevelAlarm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alarm_id")
    private Long alarmId;

    @Column(name = "alarm_status")
    private Boolean alarmStatus;

    @OneToOne
    @JoinColumn(name = "water_level_id", referencedColumnName = "water_level_id")
    private WaterLevel waterLevel;

    public WaterLevelAlarm() {

    }

    public WaterLevelAlarm(Boolean alarmStatus) {
        this.alarmStatus = alarmStatus;
    }

    public WaterLevelAlarm(Boolean alarmStatus, WaterLevel waterLevel) {
        this.alarmStatus = alarmStatus;
        this.waterLevel = waterLevel;
    }

    public Long getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(Long alarmId) {
        this.alarmId = alarmId;
    }

    public Boolean getAlarmStatus() {
        return alarmStatus;
    }

    public void setAlarmStatus(Boolean alarmStatus) {
        this.alarmStatus = alarmStatus;
    }

    public WaterLevel getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(WaterLevel waterLevel) {
        waterLevel = waterLevel;
    }

    @Override
    public String toString() {
        return "WaterLevelAlarm{" +
                "alarmId=" + alarmId +
                ", alarmStatus=" + alarmStatus +
                '}';
    }
}
