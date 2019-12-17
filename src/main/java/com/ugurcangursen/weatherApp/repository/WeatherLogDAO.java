package com.ugurcangursen.weatherApp.repository;


import com.ugurcangursen.weatherApp.entity.WeatherLog;

import java.util.List;

public interface WeatherLogDAO {
    public List<WeatherLog> findAll();
    public WeatherLog findById(long id);
    public void save(WeatherLog weatherLog);
    public void deleteById(long id);
}
