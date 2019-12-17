package com.ugurcangursen.weatherApp.repository;



import com.ugurcangursen.weatherApp.entity.City;

import java.util.List;

public interface CityDAO {
    public List<City> findAll();
    public City findById(long id);
    public void save(City city);
    public void deleteById(long id);
}
