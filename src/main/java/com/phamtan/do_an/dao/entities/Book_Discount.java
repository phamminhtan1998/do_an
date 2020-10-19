package com.phamtan.do_an.dao.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity(name = "book_discount")
@Table(name = "book_discount")
@Data
@RequiredArgsConstructor
public class Book_Discount {
    @Id
    @GeneratedValue
    private long id ;
    @Column(name = "book_id")
    private long bookId;
    @Column(name = "discount_id")
    private long discountId ;
}
//TODO: create  repo service for all the  model i create on
// Monday 20-10-2020