package com.sensorplatform.controller;

import com.sensorplatform.entity.request.WaterLevelRequest;
import com.sensorplatform.service.WaterLevelService;
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

    @RequestMapping(path = "/waterlevel", method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> persistWaterLevel(@RequestBody WaterLevelRequest waterLevelRequest) {

        logger.info("invoking persistWaterLevel() POST endpoint...");
        logger.debug("received sensor data :: " + waterLevelRequest.toString());

        waterLevelService.persistWaterLevelSensorData(waterLevelRequest);

        logger.info("completed invoking persistWaterLevel() POST endpoint...");

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
