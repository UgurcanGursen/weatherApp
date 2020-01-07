package com.ugurcangursen.weatherApp.repository.impl;


import com.ugurcangursen.weatherApp.entity.Weather;
import com.ugurcangursen.weatherApp.repository.WeatherDAO;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;


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

    @Override
    public List<Weather> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<Weather> theQuery =
                currentSession.createQuery("select a from Weather a", Weather.class);

        // execute query and get result list
        List<Weather> weathers = theQuery.getResultList();

        // return the results
        return weathers;
    }

    @Override
    public Weather findById(long id) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // get the weather
        Weather weather =
                currentSession.get(Weather.class, id);

        // return the weather
        return weather;
    }

    @Override
    public void deleteById(long id) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery(
                        "delete from Weather where id=:id");
        theQuery.setParameter("id", id);

        theQuery.executeUpdate();
    }

    @Override
    public List<Weather> findByCity(String city) {
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<Weather> theQuery =
                currentSession.createQuery("select a from Weather a where a.city =: city ", Weather.class);
        theQuery.setParameter("city", city);

        // execute query and get result list
        List<Weather> weathers = theQuery.getResultList();


        // return the results
        return weathers;
    }
}
