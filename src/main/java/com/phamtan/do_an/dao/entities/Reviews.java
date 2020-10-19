package com.phamtan.do_an.dao.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "review")
@Table(name = "review")
@Data
@RequiredArgsConstructor
public class Reviews {
    @Id
    @GeneratedValue
    private long id ;
    @Column(name = "book_id")
    private long bookId;
    @Column(name = "customer_id")
    private long customerId ;
    @Column(name = "review")
    private String review ;
    @Column(name = "date")
    private Date date ;


}
