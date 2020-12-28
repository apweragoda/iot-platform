package com.sensorplatform.utility;

import com.sensorplatform.constant.ApplicationConstants;
import com.sensorplatform.controller.WaterLevelController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

@Component
public class DateTimeUtil {

    Logger logger = LoggerFactory.getLogger(DateTimeUtil.class);

    @Value("${time.zone.id}")
    private String zoneId;

    //capture server current date time
    public Map<String, String> generateDateTimeString() {

        logger.info("invoking generateDateTimeString()...");
        logger.debug("ZONE ID :: " + zoneId);

        Map<String, String> dateTimeMap = new HashMap<String, String>();

        dateTimeMap.put(ApplicationConstants.UTIL_KEY_DATE, LocalDate.now(ZoneId.of(zoneId)).toString());
        dateTimeMap.put(ApplicationConstants.UTIL_KEY_TIME, LocalTime.now(ZoneId.of(zoneId)).toString());

        logger.debug(ApplicationConstants.UTIL_KEY_DATE + " :: " + LocalDate.now(ZoneId.of(zoneId)).toString());
        logger.debug(ApplicationConstants.UTIL_KEY_TIME + " :: " + LocalTime.now(ZoneId.of(zoneId)).toString());

        return dateTimeMap;
    }
}
