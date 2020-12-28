package com.sensorplatorm.database.repository;

import com.sensorplatorm.database.entity.FlowRate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlowRateRepository extends CrudRepository<FlowRate, Long> {

    //fetch flow rate based on date and location
    @Query("select fr from FlowRate fr where fr.date = ?1 and fr.sensor.unit.location.locationName = ?2")
    public List<FlowRate> findByLocationAndDate(String date, String location);

    //fetch flow rates as per critical status and date
    @Query("select fr from FlowRate fr where fr.date = ?1 and fr.flowRateAlarm.alarmStatus = ?2")
    public List<FlowRate> findByDateAndCriticalStatus(String date, Boolean status);
}
