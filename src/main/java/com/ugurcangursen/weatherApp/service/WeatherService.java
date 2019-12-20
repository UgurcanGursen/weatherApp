package com.ugurcangursen.weatherApp.service;

import com.ugurcangursen.weatherApp.entity.Weather;
import org.json.JSONException;

import java.io.IOException;
import java.text.ParseException;

public interface WeatherService {

    Weather getCurrentWeather(String city) throws IOException, ParseException, JSONException, org.json.simple.parser.ParseException;
    public Weather save(Weather weather);
}
