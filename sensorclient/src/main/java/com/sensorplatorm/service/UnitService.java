package com.sensorplatorm.service;

import com.sensorplatorm.constant.ApplicationConstants;
import com.sensorplatorm.database.entity.Sensor;
import com.sensorplatorm.database.entity.Unit;
import com.sensorplatorm.database.repository.UnitRepository;
import com.sensorplatorm.model.UnitSensorModelWrapper;
import com.sensorplatorm.utility.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
public class UnitService {

    @Autowired
    UnitRepository unitRepository;

    private String locationName;

    //fetch all available units
    public void fetchAllUnits(Model model) {

        Utilities.collectionModelUtil(model, ApplicationConstants.UNIT_MODEL_ATTRIBUTE,
                assembleUnitSensorModelWrapperList(false));
    }

    //fetch unit by location name
    public void fetchUnitByName(String locationName, Model model) {

        this.locationName = locationName;

        Utilities.collectionModelUtil(model, ApplicationConstants.UNIT_MODEL_ATTRIBUTE,
                assembleUnitSensorModelWrapperList(true));
    }

    //add-update existing unit
    public void addUnpdateUnit(Unit unit, Model model) {

        unitRepository.save(unit);

        Utilities.collectionModelUtil(model, ApplicationConstants.UNIT_MODEL_ATTRIBUTE,
                assembleUnitSensorModelWrapperList(false));
    }

    //delete unit
    public void deleteUnit(Long id, Model model) {

        unitRepository.deleteById(id);

        Utilities.collectionModelUtil(model, ApplicationConstants.UNIT_MODEL_ATTRIBUTE,
                assembleUnitSensorModelWrapperList(false));
    }

    //populate list of UnitSensorModelWrapper with retrieved Units
    private List<UnitSensorModelWrapper> assembleUnitSensorModelWrapperList(Boolean isSearchQuery) {

        List<Unit> unitList;
        List<UnitSensorModelWrapper> unitSensorModelWrapperList = new ArrayList<UnitSensorModelWrapper>();

        if (!isSearchQuery) {
            unitList = new ArrayList<Unit>();
            unitRepository.findAll().forEach(unitList::add);
        }
        else {
            unitList = unitRepository.findByInstalledLocation(locationName);
        }

        for (Unit unit : unitList) {
            for (Sensor sensor : unit.getSensor()) {
                unitSensorModelWrapperList.add(new UnitSensorModelWrapper(sensor.getUnit().getDeviceId(),
                        sensor.getUnit().getInstallationDate(), sensor.getUnit().getLocation(), sensor));
            }
        }

        return unitSensorModelWrapperList;
    }
}
