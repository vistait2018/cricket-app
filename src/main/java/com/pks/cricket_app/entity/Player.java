package com.pks.cricket_app.entity;

import jakarta.persistence.*;


@Entity
public class Player {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Integer playerId;
     private String role;
     private String name;

     public Player() {
     }

     public Integer getPlayerId() {
          return playerId;
     }

     public void setPlayerId(Integer playerId) {
          this.playerId = playerId;
     }

     public String getRole() {
          return role;
     }

     public void setRole(String role) {
          this.role = role;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     @Override
     public String toString() {
          return "Player{" +
                  "playerId=" + playerId +
                  ", role='" + role + '\'' +
                  ", name='" + name + '\'' +
                  '}';
     }
}
