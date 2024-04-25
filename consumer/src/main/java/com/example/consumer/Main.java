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
        handleMenuAndSelection(forecastServices, scanner);
    }

    private static void handleMenuAndSelection(List<Forecast> forecastServices, Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("\nChoose a weather forecast service:");
            System.out.println("0. Exit");

            int index = 1;
            for (Forecast service : forecastServices) {
                System.out.println(index++ + ". " + service.getClass().getSimpleName());
            }
            int selection = scanner.nextInt();
            if (selection == 0) {
                running = false;
            } else if (selection >= 1 && selection <= forecastServices.size()) {
                Forecast selectedService = forecastServices.get(selection - 1);
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
}
