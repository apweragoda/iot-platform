package com.sensorplatorm.controller;

import com.sensorplatorm.database.entity.Unit;
import com.sensorplatorm.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/unit")
public class UnitController {

    @Autowired
    UnitService unitService;

    //fetch all installed units
    @GetMapping("/getAll")
    public String getAllInstalledUnits(Model model) {

        //model.addAttribute("unit", new Unit());

        unitService.fetchAllUnits(model);

        return "unit_manager_view";
    }

    //fetch unit as per the provided name
    @GetMapping("/getByLocation")
    public String getUnitByName(@RequestParam("location") String location, Model model) {

        unitService.fetchUnitByName(location, model);

        return "unit_manager_view";
    }

    //add-update existing unit
    @PostMapping("/addUpdate")
    public String installUnit(@ModelAttribute Unit unit, Model model) {

        unitService.addUnpdateUnit(unit, model);

        return "unit_manager_view";
    }

    //delete existing unit
    @GetMapping("/delete")
    public String removeUnit(@RequestParam("unitId") Long id, Model model) {

        unitService.deleteUnit(id, model);

        return "unit_manager_view";
    }
}
