package com.phamtan.do_an.dao.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "orders")
@Table(name = "orders")
@Data
@RequiredArgsConstructor
public class Order {
    @Id
    @GeneratedValue
    private long id ;
    @Column(name = "customer_id",nullable = false,unique = true)
    private long customerId;
    @Column(name = "date")
    private String date ;
    @Column(name = "discount_id",nullable = false,unique = true)
    private long discountId;
    @Column(name = "shipper_id",nullable = false,unique = true)
    private long shipperId;
    @Column(name = "state")
    private String state ;
}
