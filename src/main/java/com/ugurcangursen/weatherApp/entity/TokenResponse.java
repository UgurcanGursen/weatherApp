package com.ugurcangursen.weatherApp.entity;

public class TokenResponse {

    private String username;
    private String token;
    private String role;

    public TokenResponse(String username, String token, String role) {
        this.username = username;
        this.token = token;
        this.role = role;
    }

    public TokenResponse() {
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
