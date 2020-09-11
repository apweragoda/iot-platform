package com.sensorplatform.repository;

import com.sensorplatform.model.WaterLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaterLevelRepository extends JpaRepository<WaterLevel, Long> {

}
