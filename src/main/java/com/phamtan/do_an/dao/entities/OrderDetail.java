package com.phamtan.do_an.dao.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity(name = "order_detail")
@Table(name = "order_detail")
@Data
@RequiredArgsConstructor
public class OrderDetail {
    @Id
    @GeneratedValue
    private long id ;
    @Column(name = "book_id")
    private long bookId;
    @Column(name = "order_id")
    private long oderId;
    private long amount;
}
