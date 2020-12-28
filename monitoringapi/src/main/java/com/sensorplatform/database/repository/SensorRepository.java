package com.sensorplatform.database.repository;

import com.sensorplatform.database.model.Sensor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends CrudRepository<Sensor,String> {

}