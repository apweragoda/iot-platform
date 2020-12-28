package com.sensorplatorm.controller;

import com.sensorplatorm.service.FlowRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FlowRateController {

    @Autowired
    private FlowRateService flowRateService;

    @GetMapping("/flowRate")
    public String getFlowRateHome() {

        return "flow_rate_view";
    }

    @GetMapping("/flowRateByLocationAndDate")
    public String flowRateByLocationAndDate(@RequestParam("location") String location, @RequestParam("date") String date, Model model) {

        //fetching flow rates and injecting model
        flowRateService.fetchFlowRateByLocationAndDate(location, date, model);

        return "flow_rate_view";
    }
}
