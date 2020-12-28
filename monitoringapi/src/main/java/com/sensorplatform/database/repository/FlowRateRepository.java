package com.sensorplatform.database.repository;

import com.sensorplatform.database.model.FlowRate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowRateRepository extends CrudRepository<FlowRate, Long> {

}
