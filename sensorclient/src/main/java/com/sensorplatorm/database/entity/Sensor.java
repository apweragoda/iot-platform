package com.sensorplatorm.database.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Sensor {

    @Id
    @Column(name = "sensor_id")
    private String sensorId;

    @Column(name = "sensor_type")
    private String sensorType;

    @ManyToOne
    @JoinColumn(name = "device_id", referencedColumnName = "device_id")
    private Unit unit;

    @OneToMany(mappedBy = "sensor", fetch = FetchType.LAZY)
    private List<FlowRate> flowRate;

    @OneToMany(mappedBy = "sensor", fetch = FetchType.LAZY)
    private List<WaterLevel> waterLevel;

    public Sensor() {

    }

    public Sensor(String sensorId, String sensorType, Unit unit) {
        this.sensorId = sensorId;
        this.sensorType = sensorType;
        this.unit = unit;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public List<FlowRate> getFlowRate() {
        return flowRate;
    }

    public void setFlowRate(List<FlowRate> flowRate) {
        this.flowRate = flowRate;
    }

    public List<WaterLevel> getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(List<WaterLevel> waterLevel) {
        this.waterLevel = waterLevel;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "sensorId='" + sensorId + '\'' +
                ", sensorType='" + sensorType + '\'' +
                ", unit=" + unit +
                ", flowRate=" + flowRate +
                ", waterLevel=" + waterLevel +
                '}';
    }
}
