package com.example.demo.entities;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "category")
@Table(name = "category")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    @Column(name = "name")
    private String name;
}
