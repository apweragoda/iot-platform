package com.sensorplatform.database.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "device_id")
    private Long deviceId;

    @Column(name = "installation_date")
    private String installationDate;

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "location_id")
    private Location location;

    @OneToMany(mappedBy = "unit")
    private List<Sensor> sensor;

    public Unit() {

    }

    public Unit(Long deviceId, Date installationDate, Location location) {
        this.deviceId = deviceId;
        this.location = location;
    }

    public Unit(String installationDate, Location location, List<Sensor> sensor) {
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

    public List<Sensor> getSensor() {
        return sensor;
    }

    public void setSensor(List<Sensor> sensor) {
        this.sensor = sensor;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "deviceId=" + deviceId +
                ", installationDate=" + installationDate +
                ", location=" + location +
                ", sensor=" + sensor +
                '}';
    }
}
