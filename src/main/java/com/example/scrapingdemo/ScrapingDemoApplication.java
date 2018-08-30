package com.example.scrapingdemo;

import com.example.scrapingdemo.services.managers.InsertWeatherData;
import com.example.scrapingdemo.services.managers.SelectData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScrapingDemoApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ScrapingDemoApplication.class, args);

        InsertWeatherData insertWeatherData = new InsertWeatherData();
        insertWeatherData.insertDataInDB();

        SelectData selectData = new SelectData();
        selectData.selectDataFromDB();
    }


}
