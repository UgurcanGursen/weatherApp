package com.ugurcangursen.weatherApp.controller;


import com.ugurcangursen.weatherApp.entity.User;
import com.ugurcangursen.weatherApp.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // expose "/users" and return list of users
    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    // add mapping for GET /users/{id}

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable long id) {

        User user = userService.findById(id);

        if (user == null) {
            throw new RuntimeException("User id not found - " + id);
        }

        return user;
    }

    // add mapping for POST /users - add new user

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {


        userService.save(user);

        return user;
    }

    // add mapping for PUT /user - update existing user

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {

        userService.save(user);

        return user;
    }

    // add mapping for DELETE /users/{id} - delete user

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable long id) {

        User user = userService.findById(id);

        // throw exception if null

        if (user == null) {
            throw new RuntimeException("User id not found - " + id);
        }

        userService.deleteById(id);

        return "Deleted user id - " + id;
    }


}
