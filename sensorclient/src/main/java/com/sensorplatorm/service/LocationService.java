package com.sensorplatorm.service;

import com.sensorplatorm.constant.ApplicationConstants;
import com.sensorplatorm.database.entity.Location;
import com.sensorplatorm.database.repository.LocationRepository;
import com.sensorplatorm.utility.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepository;

    //fetch all the locations for the water plants
    public void fetchLocations(Model model) {

        Utilities.collectionModelUtil(model, ApplicationConstants.LOCATION_MODEL_ATTRIBUTE,
                locationRepository.findAll());
    }

    //fetch plant location as per the provided name
    public void fetchLocationByName(Model model, String name) {

        Utilities.collectionModelUtil(model, ApplicationConstants.LOCATION_MODEL_ATTRIBUTE,
                locationRepository.findByLocationName(name));
    }

    //add-update locations
    public void updateLocation(Model model, Location location) {

        locationRepository.save(location);

        Utilities.collectionModelUtil(model, ApplicationConstants.LOCATION_MODEL_ATTRIBUTE,
                locationRepository.findAll());
    }

    public void deleteLocation(Model model, Long id) {

        locationRepository.deleteById(id);

        Utilities.collectionModelUtil(model, ApplicationConstants.LOCATION_MODEL_ATTRIBUTE,
                locationRepository.findAll());
    }
}
