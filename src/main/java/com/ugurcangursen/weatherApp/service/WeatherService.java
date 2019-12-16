package com.ugurcangursen.weatherApp.service;

import com.ugurcangursen.weatherApp.entity.Weather;
import java.io.IOException;

public interface WeatherService {

    Weather getWeatherByCityName(String cityName) throws IOException;

}
