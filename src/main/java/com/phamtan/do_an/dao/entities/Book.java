package com.phamtan.do_an.dao.entities;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "book")
@Table(name = "book")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "author")
    private String author;
    @Column(name = "price")
    private int price;
    @Column(name = "description")
    private String description;
    @Column(name = "cover")
    private String cover;
    @Column(name = "weight")
    private int weight;
    @Column(name = "year_publish")
    private int yearPublish;
    @Column(name = "number_page")
    private int numberPage;
    @Column(name = "sale")
    private int sale;
    @Column(name = "language")
    private String language;
    @Column(name = "image_url")
    private String image_url;
}