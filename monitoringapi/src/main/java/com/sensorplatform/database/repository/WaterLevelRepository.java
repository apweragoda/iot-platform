package com.sensorplatform.database.repository;

import com.sensorplatform.database.model.WaterLevel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaterLevelRepository extends CrudRepository<WaterLevel, Long> {

}
