package com.sensorplatform.database.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Long locationId;

    @Column(name = "location_name")
    private String locationName;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "latitude")
    private Double latitude;

    @OneToMany(mappedBy = "location")
    private List<Unit> unit;

    public Location() {

    }

    public Location(String locationName, Double longitude, Double latitude) {
        this.locationName = locationName;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Location(String locationName, Double longitude, Double latitude, List<Unit> unit) {
        this.locationName = locationName;
        this.longitude = longitude;
        this.latitude = latitude;
        this.unit = unit;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public List<Unit> getUnit() {
        return unit;
    }

    public void setUnit(List<Unit> unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", locationName='" + locationName + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", unit=" + unit +
                '}';
    }
}
