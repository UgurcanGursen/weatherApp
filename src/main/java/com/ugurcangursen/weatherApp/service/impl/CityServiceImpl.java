package com.ugurcangursen.weatherApp.service.impl;

import com.ugurcangursen.weatherApp.entity.City;
import com.ugurcangursen.weatherApp.repository.CityDAO;
import com.ugurcangursen.weatherApp.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {


    private CityDAO cityDAO;

    @Autowired
    public CityServiceImpl(CityDAO cityDAO) {
        this.cityDAO = cityDAO;
    }



    @Override
    @Transactional
    public List<City> findAll() {
        return cityDAO.findAll();
    }

    @Override
    @Transactional
    public City findById(long id) {
        return cityDAO.findById(id);
    }

    @Override
    @Transactional
    public void save(City city) {
        cityDAO.save(city);
    }


    @Override
    @Transactional
    public City deleteById(long id) {
        cityDAO.deleteById(id);
        return null;
    }
}
