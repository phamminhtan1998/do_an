package com.example.demo.entities;

import javax.persistence.*;

@Entity(name = "book_category")
@Table(name = "book_category")
public class book_category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    private long idBook;
    private long idCategory ;
}
