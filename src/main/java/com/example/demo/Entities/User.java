package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name="user")
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true , nullable=false)
    private String username;
    @Column(nullable=false)
    private String password;


    private String role;

    private boolean enabled=true;

}
