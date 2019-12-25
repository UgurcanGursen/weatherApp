package com.ugurcangursen.weatherApp.repository;


import com.ugurcangursen.weatherApp.entity.Weather;

import java.io.IOException;
import java.net.MalformedURLException;

public interface WeatherDAO {

    public void save(Weather weather) throws IOException;

}
