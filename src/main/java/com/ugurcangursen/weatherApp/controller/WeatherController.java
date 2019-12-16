package com.ugurcangursen.weatherApp.controller;

import com.ugurcangursen.weatherApp.entity.Weather;
import com.ugurcangursen.weatherApp.service.WeatherService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.text.ParseException;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/byCity/{city}")
    public Weather currentWeather(@PathVariable String city) throws IOException, ParseException, JSONException, org.json.simple.parser.ParseException {
        return weatherService.getCurrentWeather(city);
    }

}
