package com.ugurcangursen.weatherApp.repository.impl;

import com.ugurcangursen.weatherApp.entity.Weather;
import com.ugurcangursen.weatherApp.repository.WeatherDAO;
import org.hibernate.Session;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


@Repository
public class WeatherDAOImpl implements WeatherDAO {

    // define field for entitymanager
    private EntityManager entityManager;


    // set up constructor injection
    @Autowired
    public WeatherDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


    @Override
    public void save(Weather weather) throws IOException {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        String systemipaddress = "";
        URL url_name = new URL("http://bot.whatismyipaddress.com");
        BufferedReader sc =
                new BufferedReader(new InputStreamReader(url_name.openStream()));
        // reads system IPAddress
        systemipaddress = sc.readLine().trim();
        weather.setIp(systemipaddress);

        // save user
        currentSession.saveOrUpdate(weather);

    }
}
