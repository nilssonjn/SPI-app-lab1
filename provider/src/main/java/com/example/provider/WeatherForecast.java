package com.example.provider;

import com.example.service.Forecast;

public class WeatherForecast implements Forecast {

    @Override
    public String forecast(String location) {
        return "Weather forecast for " + location + ": Sunny with some clouds.";
    }
}
