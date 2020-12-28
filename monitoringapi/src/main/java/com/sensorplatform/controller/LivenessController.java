package com.sensorplatform.controller;

import com.sensorplatform.constant.ApplicationConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/check")
public class LivenessController {

    Logger logger = LoggerFactory.getLogger(LivenessController.class);

    @RequestMapping(path = "/liveness", method = RequestMethod.GET)
    public ResponseEntity<String> getLiveness() {

        logger.info("liveness endpoint is consumable...");

        return new ResponseEntity<>(ApplicationConstants.LIVENESS_RESPONSE, HttpStatus.ACCEPTED);
    }
}
