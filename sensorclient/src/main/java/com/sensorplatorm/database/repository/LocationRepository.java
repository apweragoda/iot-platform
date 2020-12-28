package com.sensorplatorm.database.repository;

import com.sensorplatorm.database.entity.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {

    //fetch locations by name
    Location findByLocationName(String locationName);
}