package com.ugurcangursen.weatherApp.service;

import com.ugurcangursen.weatherApp.entity.City;

import java.util.List;

public interface CityService {
    public List<City> findAll();

    public City findById(long id);

    public void save(City city);

    public void deleteById(long id);
}
