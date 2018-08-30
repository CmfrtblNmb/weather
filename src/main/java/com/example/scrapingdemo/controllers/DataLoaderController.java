package com.example.scrapingdemo.controllers;

import com.example.scrapingdemo.services.managers.SelectData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class DataLoaderController {

    @Autowired
    private SelectData controller;

    @GetMapping(path = "/weather")
    public List getTemperatureBy(@RequestParam String City, @RequestParam String Day) throws Exception {
        return controller.selectDataFromDB();
    }

}
