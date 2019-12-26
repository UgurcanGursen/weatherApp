package com.ugurcangursen.weatherApp.entity;

import javax.persistence.*;

@Entity
@Table(name = "weather_logs")
public class Weather extends BaseEntity {

    @Id
    @Column(name = "weather_log_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "city")
    private String city;
    private String country;
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
    private String ip;
    private String result;
    private long elapsedTime;
    private String icon;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(long elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
                "id=" + id +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", description='" + description + '\'' +
                ", temperature='" + temperature + '\'' +
                ", humidity='" + humidity + '\'' +
                ", pressure='" + pressure + '\'' +
                ", weatherID='" + weatherID + '\'' +
                ", sunriseTime='" + sunriseTime + '\'' +
                ", sunsetTime='" + sunsetTime + '\'' +
                ", date='" + date + '\'' +
                ", ip='" + ip + '\'' +
                ", result='" + result + '\'' +
                ", elapsedTime=" + elapsedTime +
                '}';
    }
}
