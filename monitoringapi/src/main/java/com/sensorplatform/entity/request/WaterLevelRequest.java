package com.sensorplatform.entity.request;

public class WaterLevelRequest {

    private String sensorId;

    private Double waterLevel;

    private Boolean alarmStatus;

    private Integer damnStatus;

    public WaterLevelRequest() {

    }

    public WaterLevelRequest(String sensorId, Double waterLevel, Boolean alarmStatus, Integer damnStatus) {
        this.sensorId = sensorId;
        this.waterLevel = waterLevel;
        this.alarmStatus = alarmStatus;
        this.damnStatus = damnStatus;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public Double getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(Double waterLevel) {
        this.waterLevel = waterLevel;
    }

    public Boolean getAlarmStatus() {
        return alarmStatus;
    }

    public void setAlarmStatus(Boolean alarmStatus) {
        this.alarmStatus = alarmStatus;
    }

    public Integer getDamnStatus() {
        return damnStatus;
    }

    public void setDamnStatus(Integer damnStatus) {
        this.damnStatus = damnStatus;
    }

    @Override
    public String toString() {
        return "WaterLevelRequest{" +
                "sensorId='" + sensorId + '\'' +
                ", waterLevel=" + waterLevel +
                ", alarmStatus=" + alarmStatus +
                ", damnStatus=" + damnStatus +
                '}';
    }
}
