package com.dt2210l.companymongo.controller;

import com.dt2210l.companymongo.entity.Employee;
import com.dt2210l.companymongo.entity.Stationery;
import com.dt2210l.companymongo.repository.StationeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("stationery")
public class StationeryController {

    @Autowired
    private StationeryRepository stationeryRepository;

    @PostMapping("all")
    public List<Stationery> addEmployees(@RequestBody List<Stationery> stationeries) {
        stationeries.forEach(stationery -> {
            stationery.setColors(new HashSet<>());
        });
        System.out.println(stationeries);
        return stationeryRepository.saveAll(stationeries);
    }
}
