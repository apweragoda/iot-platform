package com.sensorplatform.database.repository;

import com.sensorplatform.database.model.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {

    //fetch locations by name
    Location findByLocationName(String locationName);
}