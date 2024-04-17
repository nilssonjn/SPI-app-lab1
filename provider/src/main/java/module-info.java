import com.example.provider.AdvancedWeatherForecast;
import com.example.provider.WeatherForecast;
import com.example.service.Forecast;

module com.example.provider {
    requires com.example.service;

    provides Forecast with WeatherForecast, AdvancedWeatherForecast;
}