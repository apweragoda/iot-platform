package com.sensorplatform.controller;

import com.sensorplatform.entity.request.FlowRateRequest;
import com.sensorplatform.service.FlowRateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sensordata")
public class FlowRateController {

    Logger logger = LoggerFactory.getLogger(FlowRateController.class);

    @Autowired
    FlowRateService flowRateService;

    @RequestMapping(path = "/flowRate", method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> persistFlowRate(@RequestBody FlowRateRequest flowRateRequest) {

        flowRateService.persistFlowRateSensorData(flowRateRequest);

        return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
    }
}
