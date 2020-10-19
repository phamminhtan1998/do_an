package com.phamtan.do_an.dao.entities;

import javax.persistence.*;

@Entity(name = "book_category")
@Table(name = "book_category")
public class Book_Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    private long idBook;
    private long idCategory ;
}
