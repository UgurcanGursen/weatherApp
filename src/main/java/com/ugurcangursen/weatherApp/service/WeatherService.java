package com.ugurcangursen.weatherApp.service;

import com.ugurcangursen.weatherApp.entity.Weather;
import java.io.IOException;
import java.text.ParseException;

import org.json.JSONException;

public interface WeatherService {

    Weather getCurrentWeather(String city) throws IOException, ParseException, JSONException, org.json.simple.parser.ParseException;
}
