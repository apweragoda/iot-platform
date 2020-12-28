package com.sensorplatorm.database.repository;

import com.sensorplatorm.database.entity.WaterLevelAlarm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaterLevelAlarmRepository extends CrudRepository<WaterLevelAlarm, Long> {

}
