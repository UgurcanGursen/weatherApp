package com.ugurcangursen.weatherApp.repository;


import com.ugurcangursen.weatherApp.entity.Weather;

import java.io.IOException;
import java.util.List;

public interface WeatherDAO {

    public void save(Weather weather) throws IOException;

    public List<Weather> findAll();

    public Weather findById(long id);

    public List<Weather> findByCity(String city);

}
