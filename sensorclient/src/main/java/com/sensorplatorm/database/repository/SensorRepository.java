package com.sensorplatorm.database.repository;

import com.sensorplatorm.database.entity.Sensor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends CrudRepository<Sensor,String> {

}