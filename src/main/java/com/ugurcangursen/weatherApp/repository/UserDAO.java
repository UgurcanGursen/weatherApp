package com.ugurcangursen.weatherApp.repository;

import com.ugurcangursen.weatherApp.entity.User;

import java.util.List;

public interface UserDAO {

    public List<User> findAll();

    public User findById(long id);

    public void save(User user);

    public void deleteById(long id);

    public User update(long id, User user);

    User findByUsername(String userName);
}
