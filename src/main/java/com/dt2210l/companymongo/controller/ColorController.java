package com.dt2210l.companymongo.controller;

import com.dt2210l.companymongo.entity.Color;
import com.dt2210l.companymongo.entity.Employee;
import com.dt2210l.companymongo.entity.Salary;
import com.dt2210l.companymongo.entity.Stationery;
import com.dt2210l.companymongo.repository.ColorRepository;
import com.dt2210l.companymongo.repository.StationeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("color")
public class ColorController {

    @Autowired
    private ColorRepository colorRepository;

    @Autowired
    private StationeryRepository stationeryRepository;

    @PostMapping("/stationery/{staId}")
    public Set<Color> addSalariesToEmployee(@PathVariable("staId") int staId,
                                            @RequestBody Set<Color> colors) {

        Stationery stationery = stationeryRepository.findById(staId).get();
        Set<Color> colorsOld = stationery.getColors();

        colors.forEach(color -> {
            color.setStationery(stationery);
            colorRepository.save(color);
            colorsOld.add(color);
        });

        stationery.setColors(colorsOld);
        stationeryRepository.save(stationery);
        return colorsOld;
    }
}
