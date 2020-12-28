package com.sensorplatorm.database.repository;

import com.sensorplatorm.database.entity.FlowRateAlarm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowRateAlarmRepository extends CrudRepository<FlowRateAlarm, Long> {

}
