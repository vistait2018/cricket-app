package com.pks.cricket_app.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Player {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Integer playerId;


     @Column(name="role",nullable = false)
     private String role;

     @Column(name="name",nullable = false)
     private String name;


}
