package com.example.consumer;

import com.example.service.Forecast;

import java.util.Scanner;
import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ServiceLoader<Forecast> loader = ServiceLoader.load(Forecast.class);

        for (Forecast forecast : loader) {
            System.out.println("Enter location for a weather forecast: ");
            scanner.nextLine();
            System.out.println(forecast.forecast("Gothenburg"));
        }

    }
}
