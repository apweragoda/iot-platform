package com.sensorplatorm.service;

import com.sensorplatorm.constant.ApplicationConstants;
import com.sensorplatorm.database.repository.WaterLevelRepository;
import com.sensorplatorm.utility.Utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class WaterLevelService {

    @Autowired
    WaterLevelRepository waterLevelRepository;

    //fetch water level based on param and injecting model
    public void fetchWaterLevelByLocationAndDate(String location, String date, Model model){

        Utilities.collectionModelUtil(model, ApplicationConstants.WATER_LEVEL_MODEL_ATTRIBUTE,
                waterLevelRepository.findByLocationAndDate(date, location));
    }

    //fetch critical water levels for all the locations based on date
    public void fetchCriticalWaterLevel(Model model, String date, Boolean status){

        Utilities.collectionModelUtil(model, ApplicationConstants.WATER_LEVEL_MODEL_ATTRIBUTE,
                waterLevelRepository.findByDateAndCriticalStatus(date, status));
    }
}
