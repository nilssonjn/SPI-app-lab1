package com.example.provider;

import com.example.service.Forecast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AdvancedWeatherForecast implements Forecast {
    @Override
    public String forecast(String location) {
        String apiKey = System.getenv("API_KEY");
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + apiKey;

        StringBuilder response = new StringBuilder();
        try {
            URL apiUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
            } else {
                System.out.println(responseCode + ": " + connection.getResponseMessage());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return response.toString();
    }
}
