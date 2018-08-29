package com.example.scrapingdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScrapingDemoApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ScrapingDemoApplication.class, args);

        WeatherController weatherController = new WeatherController();

        weatherController.getUrl();

        weatherController.selectData();

        //System.out.println();
    }


}
