package com.ugurcangursen.weatherApp.entity;

import javax.persistence.*;

@Entity
@Table(name = "weather_logs")
public class Weather extends BaseEntity {

    @Id
    @Column(name = "weather_log_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long weather_log_id;
    @Column(name = "log_city")
    private String city;
    @Column(name = "weather_description")
    private String description;
    @Column(name = "log_temperature")
    private String temperature;
    private String humidity;
    private String pressure;
    private String weatherID;
    private String sunriseTime;
    private String sunsetTime;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeatherID() {
        return weatherID;
    }

    public void setWeatherID(String weatherID) {
        this.weatherID = weatherID;
    }

    public String getSunriseTime() {
        return sunriseTime;
    }

    public void setSunriseTime(String sunriseTime) {
        this.sunriseTime = sunriseTime;
    }

    public Long getWeather_log_id() {
        return weather_log_id;
    }

    public void setWeather_log_id(Long weather_log_id) {
        this.weather_log_id = weather_log_id;
    }

    public String getSunsetTime() {
        return sunsetTime;
    }

    public void setSunsetTime(String sunsetTime) {
        this.sunsetTime = sunsetTime;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "weather_log_id=" + weather_log_id +
                ", city='" + city + '\'' +
                ", description='" + description + '\'' +
                ", temperature='" + temperature + '\'' +
                ", humidity='" + humidity + '\'' +
                ", pressure='" + pressure + '\'' +
                ", weatherID='" + weatherID + '\'' +
                ", sunriseTime='" + sunriseTime + '\'' +
                ", sunsetTime='" + sunsetTime + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
