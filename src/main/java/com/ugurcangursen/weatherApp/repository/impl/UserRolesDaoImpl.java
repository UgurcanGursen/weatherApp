package com.ugurcangursen.weatherApp.repository.impl;

import com.ugurcangursen.weatherApp.entity.UserRoles;
import com.ugurcangursen.weatherApp.repository.UserRolesDAO;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class UserRolesDaoImpl implements UserRolesDAO {

    // define field for entitymanager
    private EntityManager entityManager;

    public UserRolesDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public UserRoles findById(int id) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // get the user
        UserRoles userRoles =
                currentSession.get(UserRoles.class, id);

        // return the user
        return userRoles;
    }
}
