package com.sensorplatform.controller;

import com.sensorplatform.model.WaterLevel;
import com.sensorplatform.service.WaterLevelService;
import com.sensorplatform.utility.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sensordata")
public class WaterLevelController {

    Logger logger = LoggerFactory.getLogger(WaterLevelController.class);

    @Autowired
    WaterLevelService waterLevelService;

    @RequestMapping(path = "/waterlevel", method = RequestMethod.GET)
    public ResponseEntity<String> getWaterLevel(@RequestParam("waterLevel") String waterLevel) {

        logger.info("invoking getWaterLevel() GET endpoint...");
        logger.debug("received data:: " + waterLevel);

        return new ResponseEntity<>(waterLevel, HttpStatus.OK);
    }

    @RequestMapping(path = "/waterlevel", method = RequestMethod.POST)
    public ResponseEntity<WaterLevel> persistWaterLevel(@RequestBody WaterLevel waterLevel) {

        logger.info("invoking persistWaterLevel() POST endpoint...");
        logger.debug("received sensor data :: " + waterLevel.toString());

        waterLevelService.persistWaterLevelSensorData(waterLevel);

        return new ResponseEntity<>(waterLevel, HttpStatus.CREATED);
    }

}
