package com.example.scrapingdemo.services.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {


    public Connection getDBConnection() throws ClassNotFoundException, SQLException {

        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/weather";
        String username = "root";
        String password = "221335533122";
        Class.forName(driver);

        Connection connection = DriverManager.getConnection(url, username, password);

        return connection;

    }


}
