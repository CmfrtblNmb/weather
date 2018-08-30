package com.example.scrapingdemo.services.managers;

import com.example.scrapingdemo.services.connections.DBConnection;
import com.example.scrapingdemo.weatherDTO.Weather;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SelectData {
    public List selectDataFromDB() throws SQLException, ClassNotFoundException {

        DBConnection dbConnection = new DBConnection();

        PreparedStatement statement;
        statement = dbConnection.getDBConnection().prepareStatement("SELECT City, Day FROM Weathers");
        ResultSet result = statement.executeQuery();

        List list = new ArrayList<Weather>();

        while (result.next()) {
            list.add(new Weather(result.getString(1), result.getString(2)));
        }
        return list;
    }

}
