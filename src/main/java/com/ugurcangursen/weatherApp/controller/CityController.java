package com.ugurcangursen.weatherApp.controller;

import com.ugurcangursen.weatherApp.entity.City;
import com.ugurcangursen.weatherApp.service.CityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/cities")
    public List<City> findAll() {
        return cityService.findAll();

    }

    @GetMapping("/city/{id}")
    public City getCity(@PathVariable long id) {
        City city = cityService.findById(id);

        if (city == null) {
            throw new RuntimeException("City id not found -" + id);
        }
        return city;
    }

    @PostMapping("/cities")
    public City addCity(@RequestBody City city) {
        cityService.save(city);
        return city;
    }

//    @PutMapping("/city/{id}")
//    public City updateCity(@PathVariable long id){
//
//        cityService.;
//    }

    @DeleteMapping("/cities/{id}")
    public String deleteCity(@PathVariable long id) {
        City city = cityService.deleteById(id);

        if (city == null) {
            throw new RuntimeException("City id is not found -" + id);
        }
        cityService.deleteById(id);
        return "Deleted city id " + id;
    }

}
