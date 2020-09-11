package com.sensorplatform.service;

import com.sensorplatform.model.WaterLevel;
import com.sensorplatform.repository.WaterLevelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WaterLevelService {

    Logger logger = LoggerFactory.getLogger(WaterLevelService.class);

    @Autowired
    WaterLevelRepository waterLevelRepository;

    public void persistWaterLevelSensorData(WaterLevel waterLevel) {

        logger.info("persisting sensor data in database...");

        WaterLevel debugWaterLevel = waterLevelRepository.save(waterLevel);

        logger.debug("persisted instance :: " + debugWaterLevel.toString());
    }
}
