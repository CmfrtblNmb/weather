package com.example.scrapingdemo.services.connections;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLConnection {

    public HttpURLConnection getHttpURLConnection() throws IOException {

        String urlJson = "https://darksky.net/forecast/41.6935,44.8015/us12/en.json";
        URL obj = new URL(urlJson);
        HttpURLConnection httpURLConnection = (HttpURLConnection) obj.openConnection();
        httpURLConnection.setRequestMethod("GET");

        return httpURLConnection;
    }
}
