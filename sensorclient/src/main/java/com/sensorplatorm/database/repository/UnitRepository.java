package com.sensorplatorm.database.repository;

import com.sensorplatorm.database.entity.Unit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitRepository extends CrudRepository<Unit, Long> {

    //fetch units by the installed location
    @Query("select u from Unit u where u.location.locationName = ?1")
    List<Unit> findByInstalledLocation(String location);
}
