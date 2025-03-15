package com.pks.cricket_app.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Player {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Integer playerId;
     private String role;
     private String name;


}
