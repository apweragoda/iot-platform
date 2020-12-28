package com.sensorplatorm.service;

import com.sensorplatorm.constant.ApplicationConstants;
import com.sensorplatorm.database.repository.FlowRateRepository;
import com.sensorplatorm.utility.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class FlowRateService {

    @Autowired
    private FlowRateRepository flowRateRepository;

    //fetch flow rate by based on location and date
    public void fetchFlowRateByLocationAndDate(String location, String date, Model model){

        Utilities.collectionModelUtil(model, ApplicationConstants.FLOW_RATE_MODEL_ATTRIBUTE,
                flowRateRepository.findByLocationAndDate(date, location));
    }

    //fetch critical flow rates
    public void criticalFlowRate(Model model, String date, Boolean status) {

        Utilities.collectionModelUtil(model, ApplicationConstants.FLOW_RATE_MODEL_ATTRIBUTE,
                flowRateRepository.findByDateAndCriticalStatus(date, status));

    }
}
