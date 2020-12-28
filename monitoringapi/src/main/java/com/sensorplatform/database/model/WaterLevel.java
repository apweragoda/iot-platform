package com.sensorplatform.database.model;

import javax.persistence.*;

@Entity
public class WaterLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "water_level_id")
    private Long waterLevelId;

    @Column(name = "water_level")
    private Double waterLevel;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    @ManyToOne
    @JoinColumn(name = "sensor_id", referencedColumnName = "sensor_id")
    private Sensor sensor;

    @OneToOne(mappedBy = "waterLevel")
    private WaterLevelAlarm waterLevelAlarm;

    public WaterLevel() {

    }

    public WaterLevel(Double waterLevel, String date, String time, Sensor sensor) {
        this.waterLevel = waterLevel;
        this.date = date;
        this.time = time;
        this.sensor = sensor;
    }

    public WaterLevel(Double waterLevel, String date, String time, Sensor sensor, WaterLevelAlarm waterLevelAlarm) {
        this.waterLevel = waterLevel;
        this.date = date;
        this.time = time;
        this.sensor = sensor;
        this.waterLevelAlarm = waterLevelAlarm;
    }

    public Long getWaterLevelId() {
        return waterLevelId;
    }

    public void setWaterLevelId(Long waterLevelId) {
        this.waterLevelId = waterLevelId;
    }

    public Double getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(Double waterLevel) {
        this.waterLevel = waterLevel;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public WaterLevelAlarm getWaterLevelAlarm() {
        return waterLevelAlarm;
    }

    public void setWaterLevelAlarm(WaterLevelAlarm waterLevelAlarm) {
        this.waterLevelAlarm = waterLevelAlarm;
    }

    @Override
    public String toString() {
        return "WaterLevel{" +
                "waterLevelId=" + waterLevelId +
                ", waterLevel=" + waterLevel +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", sensor=" + sensor.toString() + '}';
    }
}
