package com.example.scrapingdemo.services.managers;

import com.example.scrapingdemo.services.connections.DBConnection;
import com.example.scrapingdemo.services.connections.URLConnection;
import com.example.scrapingdemo.weatherDTO.Weather;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class InsertWeatherData {


    public void insertDataInDB() throws IOException, SQLException, ClassNotFoundException {

        DBConnection dbConnection = new DBConnection();
        URLConnection urlConnection = new URLConnection();

        BufferedReader in;
        in = new BufferedReader(new InputStreamReader(urlConnection.getHttpURLConnection().getInputStream()));
        String inputLine;

        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JSONObject myResponse = new JSONObject(response.toString());
        JSONArray array = myResponse.getJSONObject("daily").getJSONArray("data");

        List<Weather> weathersList = new ArrayList<>();

        Statement posted = dbConnection.getDBConnection().createStatement();

        for (int i = 0; i < array.length() - 1; i++) {
            JSONObject jsonObject = array.getJSONObject(i);
            weathersList.add(new Weather("Tbilisi", DayOfWeek.of(i + 1).toString(),
                    jsonObject.getDouble("temperatureMax"),
                    jsonObject.getString("summary")));
        }

        for (Weather weather : weathersList
        ) {
            posted.execute("INSERT INTO Weathers (City,Day,temperature,summary)" +
                    "VALUES('" + weather.getCity() + "','" + weather.getDay()
                    + "','" + weather.getTemperature() + "','" + weather.getSummary() + "')");
        }
    }


}
