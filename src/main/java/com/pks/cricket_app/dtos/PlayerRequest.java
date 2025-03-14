package com.pks.cricket_app.dtos;

import lombok.Data;

public class PlayerRequest {
    private  String name;
    private String role;

    public PlayerRequest() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "PlayerRequest{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
