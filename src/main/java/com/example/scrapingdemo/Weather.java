package com.example.scrapingdemo;

public class Weather {

    private String City;
    private String Day;
    private double temperature;
    private  String summary;

    public Weather(String city, String day, double temperature, String summary) {
        City = city;
        Day = day;
        this.temperature = temperature;
        this.summary = summary;
    }


    public Weather(String city, String day) {
        City = city;
        Day = day;
    }

    public Weather() {


    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public  String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
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
