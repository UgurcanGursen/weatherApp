package com.ugurcangursen.weatherApp.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "weatherLog_db")
public class WeatherLog extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "city_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private City city_id;

    @JoinColumn(name = "user_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private User user;


    @Column (name = "temperature")
    private String temperature;

    @Column (name = "query_result")
    private boolean queryResult;

    @Column (name = "query_time")
    private String queryTime;

    public WeatherLog(Long id, City city_id, User user) {
        super();
        this.id=id;
        this.city_id=city_id;
        this.user=user;
    }

    public WeatherLog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public City getCity_id() {
        return city_id;
    }

    public void setCity_id(City city_id) {
        this.city_id = city_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
