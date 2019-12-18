package com.ugurcangursen.weatherApp.service.impl;

import com.ugurcangursen.weatherApp.entity.User;
import com.ugurcangursen.weatherApp.repository.UserDAO;
import com.ugurcangursen.weatherApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Override
    @Transactional
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    @Transactional
    public User findById(long id) {
        return userDAO.findById(id);
    }

    @Override
    @Transactional
    public void save(User user) {
        userDAO.save(user);
    }


    @Override
    @Transactional
    public void deleteById(long id) {
        userDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void update(long id, User user) {
        userDAO.update(id, user);
    }
}
