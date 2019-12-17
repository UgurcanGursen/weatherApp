package com.ugurcangursen.weatherApp.repository.impl;

import com.ugurcangursen.weatherApp.entity.City;
import com.ugurcangursen.weatherApp.entity.User;
import com.ugurcangursen.weatherApp.repository.CityDAO;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CityDaoImpl implements CityDAO {
    private EntityManager entityManager;

    public CityDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public List<City> findAll() {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<City> theQuery =
                currentSession.createQuery("select a from City a", City.class);

        List<City>  cities = theQuery.getResultList();

        // return the results
        return cities;
    }

    @Override
    public City findById(long id) {
        Session currentSession = entityManager.unwrap(Session.class);

        City city =
                currentSession.get(City.class, id);

        return city;
    }

    @Override
    public void save(City city) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // save city
        currentSession.saveOrUpdate(city);
    }



    @Override
    public void deleteById(long id) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery(
                        "delete from City where id=:id");
        theQuery.setParameter("id", id);

        theQuery.executeUpdate();


    }
}
