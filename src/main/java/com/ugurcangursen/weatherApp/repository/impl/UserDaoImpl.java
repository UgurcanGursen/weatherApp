package com.ugurcangursen.weatherApp.repository.impl;



import com.ugurcangursen.weatherApp.entity.User;
import com.ugurcangursen.weatherApp.entity.UserRoles;
import com.ugurcangursen.weatherApp.repository.UserDAO;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDAO {

    // define field for entitymanager
    private EntityManager entityManager;



    // set up constructor injection
    @Autowired
    public UserDaoImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<User> findAll() {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<User> theQuery =
                currentSession.createQuery("select a from User a", User.class);

        // execute query and get result list
        List<User> users = theQuery.getResultList();

        // return the results
        return users;
    }

    @Override
    public User findById(long id) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // get the user
        User user =
                currentSession.get(User.class, id);

        // return the user
        return user;
    }

    @Override
    public User findByUsername(String userName) {
        Session currentSession = entityManager.unwrap(Session.class);

        // get the user
        User user =
                currentSession.get(User.class, userName);

        // return the user
        return user;
    }

    @Override
    public void save(User user) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
        // save user
        currentSession.saveOrUpdate(user);
    }


    @Override
    public void deleteById(long id) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery(
                        "delete from User where id=:id");
        theQuery.setParameter("id", id);

        theQuery.executeUpdate();


    }

    @Override
    public User update(long id, User user) {


        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("update User  set password =:password,userName = :username where id =:id");
        theQuery.setParameter("id", id);
        theQuery.setParameter("username", user.getUserName());
        theQuery.setParameter("password", user.getPassword());
        theQuery.executeUpdate();
        return user;

    }




}



