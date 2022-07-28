package com.practice.multidbspringboot.Resource;


import lombok.Data;

import javax.persistence.*;


@Entity(name = "Blog")
@Data
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String owner;
    @Column(length = 300)
    private String content;

}
