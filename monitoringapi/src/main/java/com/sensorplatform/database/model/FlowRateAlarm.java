package com.sensorplatform.database.model;

import javax.persistence.*;

@Entity
public class FlowRateAlarm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alarm_id")
    private Long alarmId;

    @Column(name = "alarm_status")
    private Boolean alarmStatus;

    @OneToOne
    @JoinColumn(name = "flow_rate_id", referencedColumnName = "flow_rate_id")
    private FlowRate flowRate;

    public FlowRateAlarm() {

    }

    public FlowRateAlarm(Boolean alarmStatus) {
        this.alarmStatus = alarmStatus;
    }

    public FlowRateAlarm(Boolean alarmStatus, FlowRate flowRate) {
        this.alarmStatus = alarmStatus;
        this.flowRate = flowRate;
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

    public FlowRate getFlowRate() {
        return flowRate;
    }

    public void setFlowRate(FlowRate flowRate) {
        this.flowRate = flowRate;
    }

    @Override
    public String toString() {
        return "FlowRateAlarm{" +
                "alarmId=" + alarmId +
                ", alarmStatus=" + alarmStatus +
                ", flowRate=" + flowRate +
                '}';
    }
}
