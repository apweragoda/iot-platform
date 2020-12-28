package com.sensorplatform.database.repository;

import com.sensorplatform.database.model.WaterLevelAlarm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaterLevelAlarmRepository extends CrudRepository<WaterLevelAlarm, Long> {

}
