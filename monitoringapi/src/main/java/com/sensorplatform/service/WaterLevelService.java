package com.sensorplatform.service;

import com.sensorplatform.constant.ApplicationConstants;
import com.sensorplatform.database.model.Sensor;
import com.sensorplatform.database.model.WaterLevel;
import com.sensorplatform.database.model.WaterLevelAlarm;
import com.sensorplatform.database.repository.SensorRepository;
import com.sensorplatform.database.repository.WaterLevelAlarmRepository;
import com.sensorplatform.database.repository.WaterLevelRepository;
import com.sensorplatform.entity.request.WaterLevelRequest;
import com.sensorplatform.utility.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;

@Service
public class WaterLevelService {

    Logger logger = LoggerFactory.getLogger(WaterLevelService.class);

    @Autowired
    SensorRepository sensorRepository;

    @Autowired
    WaterLevelRepository waterLevelRepository;

    @Autowired
    WaterLevelAlarmRepository waterLevelAlarmRepository;

    @Autowired
    DateTimeUtil dateTimeUtil;

    //persist water level retrieved via sensor
    @Transactional
    public void persistWaterLevelSensorData(WaterLevelRequest waterLevelRequest) {

        //get date time from server
        Map<String,String> dateTimeMap = dateTimeUtil.generateDateTimeString();

        //fetch the relevant sensor from database
        Sensor sensor = sensorRepository.findById(waterLevelRequest.getSensorId()).get();

        //prepare & persist WaterLevel in database
        WaterLevel waterLevel = waterLevelRepository.save(new WaterLevel(waterLevelRequest.getWaterLevel(),
                dateTimeMap.get(ApplicationConstants.UTIL_KEY_DATE), dateTimeMap.get(ApplicationConstants.UTIL_KEY_TIME),
                sensor));

        //prepare & persist WaterLevelAlarm in database
        waterLevelAlarmRepository.save(new WaterLevelAlarm(waterLevelRequest.getAlarmStatus(), waterLevel));
    }
}
