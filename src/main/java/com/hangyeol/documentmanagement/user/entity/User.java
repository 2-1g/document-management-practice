package com.hangyeol.documentmanagement.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    public static User from(String userName) {
        return new User(userName);
    }

    private User(String userName) {
        this.name = userName;
    }

}
