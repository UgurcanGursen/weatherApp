package com.ugurcangursen.weatherApp.repository.impl;

import com.ugurcangursen.weatherApp.entity.WeatherLog;
import com.ugurcangursen.weatherApp.repository.WeatherLogDAO;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class WeatherLogDaoImpl implements WeatherLogDAO {
    private EntityManager entityManager;

    public WeatherLogDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public List<WeatherLog> findAll() {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<WeatherLog> theQuery =
                currentSession.createQuery("select a from City a", WeatherLog.class);

        List<WeatherLog>  weatherLogs = theQuery.getResultList();

        // return the results
        return weatherLogs;
    }

    @Override
    public WeatherLog findById(long id) {
        Session currentSession = entityManager.unwrap(Session.class);

        WeatherLog weatherLog =
                currentSession.get(WeatherLog.class, id);

        return weatherLog;
    }

    @Override
    public void save(WeatherLog weatherLog) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // save city
        currentSession.saveOrUpdate(weatherLog);
    }



    @Override
    public void deleteById(long id) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery(
                        "delete from WeatherLog where id=:id");
        theQuery.setParameter("id", id);

        theQuery.executeUpdate();


    }
}
