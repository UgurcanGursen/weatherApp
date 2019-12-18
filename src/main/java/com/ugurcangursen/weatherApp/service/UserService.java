package com.ugurcangursen.weatherApp.service;

import com.ugurcangursen.weatherApp.entity.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();

    public User findById(long id);

    public void save(User user);

    public void deleteById(long id);

    public void update(long id, User user);
}
