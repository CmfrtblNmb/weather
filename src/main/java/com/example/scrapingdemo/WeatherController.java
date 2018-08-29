package com.example.scrapingdemo;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import javax.swing.event.ListDataEvent;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class WeatherController {


    public void getUrl() throws Exception {


        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/weather";
        String username = "root";
        String password = "221335533122";
        Class.forName(driver);

        Connection cn = DriverManager.getConnection(url, username, password);


        String urlJson = "https://darksky.net/forecast/41.6935,44.8015/us12/en.json";
        URL obj = new URL(urlJson);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();


        con.setRequestMethod("GET");


        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String inputLine;

        StringBuffer response = new StringBuffer();


        while ((inputLine = in.readLine()) != null) {

            response.append(inputLine);
        }

        in.close();

        JSONObject myResponse = new JSONObject(response.toString());

        List list = new ArrayList();

        list.add(myResponse.getJSONObject("daily").getJSONArray("data"));


        JSONArray array = myResponse.getJSONObject("daily").getJSONArray("data");

        List<Weather> list1 = new ArrayList<>();

        for (int i = 0; i < array.length() - 1; i++) {
            JSONObject jsonObject = array.getJSONObject(i);

            list1.add(new Weather("Tbilisi", DayOfWeek.of(i + 1).toString(), jsonObject.getDouble("temperatureMax"),
                    jsonObject.getString("summary")));

        }

        Statement posted = cn.createStatement();

        for (Weather weather : list1) {

            posted.execute("INSERT INTO Weathers (City,Day,temperature,summary)" +
                    "VALUES('" + weather.getCity() + "','" + weather.getDay() + "','" + weather.getTemperature() + "','" + weather.getSummary() + "')");

        }


    }

    public List selectData() throws Exception {


        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/weather";
        String username = "root";
        String password = "221335533122";
        Class.forName(driver);

        Connection cn = DriverManager.getConnection(url, username, password);


        PreparedStatement statement = cn.prepareStatement("SELECT City, Day FROM Weathers");

        ResultSet result = statement.executeQuery();


        Gson gson = new Gson();
        Type type = new TypeToken<List<Weather>>() {
        }.getType();


        List list = new ArrayList<Weather>();

        while (result.next()) {
            list.add(new Weather(result.getString(1), result.getString(2)));

            //  System.out.println(result.getString(1));
        }


        return list;


    }
}
