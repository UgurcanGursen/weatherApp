package com.ugurcangursen.weatherApp.service.impl;

import com.ugurcangursen.weatherApp.entity.WeatherLog;
import com.ugurcangursen.weatherApp.repository.WeatherLogDAO;
import com.ugurcangursen.weatherApp.service.WeatherLogService;

import java.util.List;

public class WeatherLogServiceImpl implements WeatherLogService {

    private WeatherLogDAO weatherLogDAO;

    public WeatherLogServiceImpl(WeatherLogDAO weatherLogDAO) {
        this.weatherLogDAO = weatherLogDAO;
    }

    @Override
    public List<WeatherLog> findAll() {
        return weatherLogDAO.findAll();
    }

    @Override
    public WeatherLog findById(long id) {
        return weatherLogDAO.findById(id);
    }

    @Override
    public void save(WeatherLog weatherLog) {
        weatherLogDAO.save(weatherLog);

    }

    @Override
    public void deleteById(long id) {
        weatherLogDAO.deleteById(id);
    }
}
