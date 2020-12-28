package com.sensorplatorm.database.entity;

import javax.persistence.*;

@Entity
public class FlowRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flow_rate_id")
    private Long flowRateId;

    @Column(name = "flow_rate")
    private Double flowRate;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    @ManyToOne
    @JoinColumn(name = "sensor_id", referencedColumnName = "sensor_id")
    private Sensor sensor;

    @OneToOne(mappedBy = "flowRate")
    private FlowRateAlarm flowRateAlarm;

    public FlowRate() {

    }

    public FlowRate(Double flowRate, String date, String time, Sensor sensor) {
        this.flowRate = flowRate;
        this.date = date;
        this.time = time;
        this.sensor = sensor;
    }

    public FlowRate(Double flowRate, String date, String time, Sensor sensor, FlowRateAlarm flowRateAlarm) {
        this.flowRate = flowRate;
        this.date = date;
        this.time = time;
        this.sensor = sensor;
        this.flowRateAlarm = flowRateAlarm;
    }

    public Long getFlowRateId() {
        return flowRateId;
    }

    public void setFlowRateId(Long flowRateId) {
        this.flowRateId = flowRateId;
    }

    public Double getFlowRate() {
        return flowRate;
    }

    public void setFlowRate(Double flowRate) {
        this.flowRate = flowRate;
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

    public FlowRateAlarm getFlowRateAlarm() {
        return flowRateAlarm;
    }

    public void setFlowRateAlarm(FlowRateAlarm flowRateAlarm) {
        this.flowRateAlarm = flowRateAlarm;
    }

    @Override
    public String toString() {
        return "FlowRate{" +
                "flowRateId=" + flowRateId +
                ", flowRate=" + flowRate +
                ", date=" + date +
                ", time=" + time +
                ", sensor=" + sensor +
                ", flowRateAlarm=" + flowRateAlarm +
                '}';
    }
}
