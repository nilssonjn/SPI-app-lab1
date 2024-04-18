package com.example.consumer;

import com.example.service.Forecast;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ServiceLoader<Forecast> loader = ServiceLoader.load(Forecast.class);
        List<Forecast> forecastServices = new ArrayList<>();

        for (Forecast service : loader) {
            forecastServices.add(service);
        }

        System.out.println("Choose a weather forecast service:");
        int index = 1;
        for (Forecast service : forecastServices) {
            System.out.println(index++ + ". " + service.getClass().getSimpleName());
        }
        int choice = scanner.nextInt();
        if (choice >= 1 && choice <= forecastServices.size()) {
            Forecast selectedService = forecastServices.get(choice - 1);
            System.out.println("Enter location:");
            scanner.nextLine();
            String location = scanner.nextLine();
            String forecast = selectedService.forecast(location);
            System.out.println(forecast);
        } else {
            System.out.println("Invalid choice!");
        }

    }
}
