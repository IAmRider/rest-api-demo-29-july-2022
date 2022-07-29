package com.practice.multidbspringboot.model.user;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(schema = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private int age;
}
