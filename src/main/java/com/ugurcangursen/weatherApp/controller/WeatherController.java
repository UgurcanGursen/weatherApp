package com.ugurcangursen.weatherApp.controller;

import com.sun.deploy.net.HttpResponse;
import com.ugurcangursen.weatherApp.entity.Weather;
import com.ugurcangursen.weatherApp.service.WeatherService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.elasticsearch.jest.HttpClientConfigBuilderCustomizer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;


@RestController
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @RequestMapping(value = "/weather/{city}", method = {RequestMethod.GET})
    public ResponseEntity<Weather> currentWeather(@PathVariable String city) throws IOException, ParseException, JSONException, org.json.simple.parser.ParseException {

        long start = System.currentTimeMillis();
        Weather wt = weatherService.getCurrentWeather(city);
        long end = System.currentTimeMillis();
        long elapsed = end - start;
        wt.setElapsedTime(elapsed);
        weatherService.save(wt);

        return ResponseEntity.ok(wt);
    }


}
