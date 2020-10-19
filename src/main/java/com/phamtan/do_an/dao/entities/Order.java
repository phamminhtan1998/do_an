package com.phamtan.do_an.dao.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "order")
@Table(name = "order")
@Data
@RequiredArgsConstructor
public class Order {
    @Id
    @GeneratedValue
    private long id ;
    @Column(name = "customer_id",nullable = false,unique = true)
    private long customerId;
    private Date date ;
    @Column(name = "discount_id",nullable = false,unique = true)
    private long discountId;
    @Column(name = "shipper_id",nullable = false,unique = true)
    private long shipperId;
    private String state ;
}
