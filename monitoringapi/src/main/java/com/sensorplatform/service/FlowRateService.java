package com.sensorplatform.service;

import com.sensorplatform.constant.ApplicationConstants;
import com.sensorplatform.database.model.*;
import com.sensorplatform.database.repository.FlowRateAlarmRepository;
import com.sensorplatform.database.repository.FlowRateRepository;
import com.sensorplatform.database.repository.SensorRepository;
import com.sensorplatform.entity.request.FlowRateRequest;
import com.sensorplatform.utility.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;

@Service
public class FlowRateService {

    Logger logger = LoggerFactory.getLogger(FlowRateService.class);

    @Autowired
    SensorRepository sensorRepository;

    @Autowired
    FlowRateRepository flowRateRepository;

    @Autowired
    FlowRateAlarmRepository flowRateAlarmRepository;

    @Autowired
    DateTimeUtil dateTimeUtil;

    //persist flow rates retrieved via sensor
    @Transactional
    public void persistFlowRateSensorData(FlowRateRequest flowRateRequest) {

        //get date time from server
        Map<String,String> dateTimeMap = dateTimeUtil.generateDateTimeString();

        //fetch the relevant sensor from database
        Sensor sensor = sensorRepository.findById(flowRateRequest.getSensorId()).get();

        //prepare & persist FlowRate entity in database
        FlowRate flowRate = flowRateRepository.save(new FlowRate(flowRateRequest.getFlowRate(),
                dateTimeMap.get(ApplicationConstants.UTIL_KEY_DATE), dateTimeMap.get(ApplicationConstants.UTIL_KEY_TIME),
                sensor));

        //prepare & persist FlowRateAlarm entity in database
        flowRateAlarmRepository.save(new FlowRateAlarm(flowRateRequest.getAlarmStatus(), flowRate));
    }

}
