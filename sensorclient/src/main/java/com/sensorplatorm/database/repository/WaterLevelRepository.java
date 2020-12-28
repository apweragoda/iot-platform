package com.sensorplatorm.database.repository;

import com.sensorplatorm.database.entity.WaterLevel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WaterLevelRepository extends CrudRepository<WaterLevel, Long> {

    //fetch water levels based on location and date
    @Query("select wl from WaterLevel wl where wl.date = ?1 and wl.sensor.unit.location.locationName = ?2")
    List<WaterLevel> findByLocationAndDate(String date, String location);

    //fetch water levels as per critical status and date
    @Query("select wl from WaterLevel wl where wl.date = ?1 and wl.waterLevelAlarm.alarmStatus = ?2")
    List<WaterLevel> findByDateAndCriticalStatus(String date, Boolean  status);
}
