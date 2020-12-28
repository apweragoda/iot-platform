package com.sensorplatorm.model;

import com.sensorplatorm.database.entity.Location;
import com.sensorplatorm.database.entity.Sensor;

public class UnitSensorModelWrapper {

    private Long deviceId;

    private String installationDate;

    private Location location;

    private Sensor sensor;

    public UnitSensorModelWrapper() {

    }

    public UnitSensorModelWrapper(Long deviceId, String installationDate, Location location, Sensor sensor) {
        this.deviceId = deviceId;
        this.installationDate = installationDate;
        this.location = location;
        this.sensor = sensor;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public String getInstallationDate() {
        return installationDate;
    }

    public void setInstallationDate(String installationDate) {
        this.installationDate = installationDate;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    @Override
    public String toString() {
        return "UnitSensorModelWrapper{" +
                "deviceId=" + deviceId +
                ", installationDate='" + installationDate + '\'' +
                ", location=" + location +
                ", sensor=" + sensor +
                '}';
    }
}
