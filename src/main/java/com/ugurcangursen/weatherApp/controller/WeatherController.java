package com.ugurcangursen.weatherApp.controller;


import com.ugurcangursen.weatherApp.entity.Weather;
import com.ugurcangursen.weatherApp.service.WeatherService;
import com.ugurcangursen.weatherApp.util.ControllerPaths;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;


@RestController
@RequestMapping(ControllerPaths.WeatherCtrl.CTRL)
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @RequestMapping(value = "/{city}", method = {RequestMethod.GET})
    public Weather currentWeather(@PathVariable String city) throws IOException, ParseException, JSONException, org.json.simple.parser.ParseException {

        Weather wt = new Weather();
        long start = System.currentTimeMillis();
        try {
            wt = weatherService.getCurrentWeather(city);
        } catch (Exception e) {
        }

        long end = System.currentTimeMillis();
        long elapsed = end - start;
        wt.setElapsedTime(elapsed);

        if (wt.getCountry() == null) {
            wt.setResult("BAŞARISIZ");
        } else {
            wt.setResult("BAŞARILI");
        }

        wt.setCity(city);
        weatherService.save(wt);

        return wt;
    }

    @GetMapping()
    public List<Weather> findAll() {
        return weatherService.findAll();
    }


    @GetMapping("/a/{id}")
    public Weather getWeathersLogById(@PathVariable long id) {

        Weather weather = weatherService.findById(id);

        if (weather == null) {
            throw new RuntimeException("Weather id not found - " + id);
        }

        return weather;
    }

    @GetMapping("/weathers/{city}")
    public List<Weather> getWeatherLogByCity(@PathVariable String city) {

        List<Weather> weather = weatherService.findByCity(city);

        if (weather == null) {
            throw new RuntimeException("City not found - " + city);
        }

        return weather;
    }


}
