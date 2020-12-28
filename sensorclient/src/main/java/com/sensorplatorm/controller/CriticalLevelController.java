package com.sensorplatorm.controller;

import com.sensorplatorm.service.FlowRateService;
import com.sensorplatorm.service.WaterLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class CriticalLevelController {

    @Autowired
    private WaterLevelService levelService;

    @Autowired
    private FlowRateService flowRateService;

    @GetMapping("/criticalLevel")
    public String getCriticalLevelHome(Model model) {

        //fetch critical water levels as per today
        levelService.fetchCriticalWaterLevel(model, LocalDate.now().toString(),true);
        //fetch critical flow rates as per today
        flowRateService.criticalFlowRate(model, LocalDate.now().toString(),true);

        return "critical_level_view";
    }

    @GetMapping("/waterCriticalLevel")
    public String getWaterCriticalLevel(@RequestParam("date") String date, Model model) {

        //fetch critical water levels as per requested date
        levelService.fetchCriticalWaterLevel(model, date,true);
        //fetch critical flow rates as per today
        flowRateService.criticalFlowRate(model, LocalDate.now().toString(),true);

        return "critical_level_view";
    }

    @GetMapping("/flowRateCriticalLevel")
    public String getFlowRateCriticalLevel(@RequestParam("date") String date, Model model) {

        //fetch critical flow rates as per requested date
        flowRateService.criticalFlowRate(model, date,true);
        //fetch critical water levels as per today
        levelService.fetchCriticalWaterLevel(model, LocalDate.now().toString(),true);

        return "critical_level_view";
    }
}
