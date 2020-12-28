package com.sensorplatform.entity.request;

public class FlowRateRequest {

    private String sensorId;

    private Double flowRate;

    private Boolean alarmStatus;

    public FlowRateRequest() {

    }

    public FlowRateRequest(String sensorId, Double flowRate, Boolean alarmStatus) {
        this.sensorId = sensorId;
        this.flowRate = flowRate;
        this.alarmStatus = alarmStatus;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public Double getFlowRate() {
        return flowRate;
    }

    public void setFlowRate(Double flowRate) {
        this.flowRate = flowRate;
    }

    public Boolean getAlarmStatus() {
        return alarmStatus;
    }

    public void setAlarmStatus(Boolean alarmStatus) {
        this.alarmStatus = alarmStatus;
    }

    @Override
    public String toString() {
        return "FlowRateRequest{" +
                "sensorId='" + sensorId + '\'' +
                ", flowRate=" + flowRate +
                ", alarmStatus=" + alarmStatus +
                '}';
    }
}
