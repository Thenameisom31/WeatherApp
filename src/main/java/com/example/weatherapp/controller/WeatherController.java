package com.example.weatherapp.controller;

import com.example.weatherapp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather")
    public String getWeather(@RequestParam(name = "city", required = false, defaultValue = "London") String city,
            Model model) {
        try {
            Map<String, Object> weatherData = weatherService.getWeather(city);
            model.addAttribute("weather", weatherData);
            model.addAttribute("city", city);
        } catch (Exception e) {
            e.printStackTrace(); // Log the full error
            model.addAttribute("error",
                    "Could not fetch weather for " + city + ". Please check the city name or API key. Error: "
                            + e.getMessage());
        }
        return "weather";
    }
}
