package com.sensorplatorm.controller;

import com.sensorplatorm.service.WaterLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WaterLevelController {

    @Autowired
    private WaterLevelService waterLevelService;

    @GetMapping("/waterLevel")
    public String waterLevelHome() {

        return "water_level_view";
    }

    @GetMapping("/waterLevelByLocationAndDate")
    public String waterLevelByLocationAndDate(@RequestParam("location") String location, @RequestParam("date") String date, Model model) {

        //fetching water level and injecting model
        waterLevelService.fetchWaterLevelByLocationAndDate(location, date, model);

        return "water_level_view";
    }
}
