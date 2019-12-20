package com.ugurcangursen.weatherApp.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "city_db")
public class City extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city_name")
    private String cityName;

    @JoinColumn(name = "user_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Weather> weatherLog;

    public City() {
    }

    public City(Long id, String cityName, List<Weather> weatherLog) {
        super();

        this.id = id;
        this.cityName = cityName;
        this.weatherLog = weatherLog;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Weather> getWeatherLog() {
        return weatherLog;
    }

    public void setWeatherLog(List<Weather> weatherLog) {
        this.weatherLog = weatherLog;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
