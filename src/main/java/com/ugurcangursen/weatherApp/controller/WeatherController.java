package com.ugurcangursen.weatherApp.controller;

import com.ugurcangursen.weatherApp.entity.Weather;
import com.ugurcangursen.weatherApp.service.WeatherService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.ParseException;


@RestController
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @RequestMapping(value = "/weather/{city}", method = {RequestMethod.GET})
    public Weather currentWeather(@PathVariable String city) throws IOException, ParseException, JSONException, org.json.simple.parser.ParseException {

        return weatherService.getCurrentWeather(city);
    }

//    @RequestMapping(value = "/weather/{city}", method = {RequestMethod.POST})
//    public Weather currentWeatherPOST(@PathVariable String city) throws IOException, ParseException, JSONException, org.json.simple.parser.ParseException {
//
//        Weather postW = weatherService.getCurrentWeather(city);
//        weatherService.save(postW);
//         return postW;
//    }


}
