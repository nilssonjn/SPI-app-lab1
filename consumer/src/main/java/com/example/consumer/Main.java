package com.example.consumer;

import com.example.service.Forecast;

import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {

        ServiceLoader<Forecast> loader = ServiceLoader.load(Forecast.class);

        for (Forecast forecast : loader) {
            System.out.println(forecast.forecast("Gothenburg"));
        }

    }
}
