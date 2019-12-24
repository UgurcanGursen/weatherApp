package com.ugurcangursen.weatherApp.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "roles_db")
public class UserRoles implements Serializable {

    @Id
    @Column(name = "id",insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "role_name",insertable = false, updatable = false)
    private String role_name;


    @OneToMany(mappedBy="role")
    private List<User> user;


    public UserRoles() {
    }

    public UserRoles(int id) {
        super();
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

}
