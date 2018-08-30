package com.example.scrapingdemo.weatherDTO;

public class Weather {
    private String city;
    private String day;
    private double temperature;
    private String summary;


    public Weather(String city, String day, double temperature, String summary) {
        this.city = city;
        this.day = day;
        this.temperature = temperature;
        this.summary = summary;
    }

    public Weather(String city, String day) {
        this.city = city;
        this.day = day;
    }

    public Weather() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}