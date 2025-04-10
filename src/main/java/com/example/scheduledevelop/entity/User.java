package com.example.scheduledevelop.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name ="user")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    public User() {
    }

    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public void updatePassword(String password) {
        this.password = password;
    }
}
