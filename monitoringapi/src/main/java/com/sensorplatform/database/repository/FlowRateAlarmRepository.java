package com.sensorplatform.database.repository;

import com.sensorplatform.database.model.FlowRateAlarm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowRateAlarmRepository extends CrudRepository<FlowRateAlarm, Long> {

}
