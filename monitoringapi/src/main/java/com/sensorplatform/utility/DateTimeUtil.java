package com.sensorplatform.utility;

import com.sensorplatform.constant.ApplicationConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

@Component
public class DateTimeUtil {

    @Value("${time.zone.id}")
    private String zoneId;

    //capture server current date time
    public Map<String, String> generateDateTimeString() {

        Map<String, String> dateTimeMap = new HashMap<String, String>();

        dateTimeMap.put(ApplicationConstants.UTIL_KEY_DATE, LocalDate.now(ZoneId.of(zoneId)).toString());
        dateTimeMap.put(ApplicationConstants.UTIL_KEY_TIME, LocalTime.now(ZoneId.of(zoneId)).toString());

        return dateTimeMap;
    }
}
